package eu.padroes_de_projeto.services;

import eu.padroes_de_projeto.model.Address;
import eu.padroes_de_projeto.model.AddressRepository;
import eu.padroes_de_projeto.model.Client;
import eu.padroes_de_projeto.model.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.stream.events.EndElement;
import java.util.Optional;

@Service
public class ServicesImplementation implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private ViaCepService viaCepService;

    @Override
    public Iterable<Client> selectAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client selectById(Long id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @Override
    public Client insert(Client client) {
        return createClientWithCep(client);
    }

    @Override
    public Client update(Long id, Client client) {
        if(!clientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        client.setId(id);
        return createClientWithCep(client);
    }

    @Override
    public void delete(Long id) {
        if(!clientRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado");
        }

        clientRepository.deleteById(id);
    }

    private Client createClientWithCep(Client client) {
        String clientCep = client.getAddress().getCep();

        Address address = addressRepository.findById(clientCep).orElseGet(() -> {
            Address newAddress = viaCepService.checkCep(clientCep);
            return addressRepository.save(newAddress);
        });

        client.setAddress(address);
        return clientRepository.save(client);
    }
}
