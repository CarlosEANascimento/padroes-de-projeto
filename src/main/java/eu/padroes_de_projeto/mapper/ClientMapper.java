package eu.padroes_de_projeto.mapper;

import eu.padroes_de_projeto.dto.AddressRequestDTO;
import eu.padroes_de_projeto.dto.AddressResponseDTO;
import eu.padroes_de_projeto.dto.ClientRequestDTO;
import eu.padroes_de_projeto.dto.ClientResponseDTO;
import eu.padroes_de_projeto.model.Address;
import eu.padroes_de_projeto.model.Client;
import org.springframework.stereotype.Component;

@Component
public class ClientMapper {
    // INSERT PURPOSES
    public Client toEntity(ClientRequestDTO dto) {
        Client client = new Client();
        client.setName(dto.getName());
        Address address = new Address();
        address.setCep(dto.getAddress().getCep());
        client.setAddress(address);
        return client;
    }

    // UPDATE PORPUSES
    public Client toEntity(Long id ,ClientRequestDTO dto) {
        Client client = new Client();
        client.setId(id);
        client.setName(dto.getName());

        Address address = new Address();
        address.setCep(dto.getAddress().getCep());
        client.setAddress(address);

        return client;
    }

    public ClientResponseDTO toResponseDTO(Client client) {
        ClientResponseDTO clientDTO = new ClientResponseDTO();
        clientDTO.setId(client.getId());
        clientDTO.setName(client.getName());

        AddressResponseDTO addressDTO = new  AddressResponseDTO();
        addressDTO.setCep(client.getAddress().getCep());
        addressDTO.setLogradouro(client.getAddress().getLogradouro());
        addressDTO.setBairro(client.getAddress().getBairro());
        addressDTO.setLocalidade(client.getAddress().getLocalidade());
        addressDTO.setUf(client.getAddress().getUf());

        clientDTO.setAddress(addressDTO);
        return clientDTO;
    }
}
