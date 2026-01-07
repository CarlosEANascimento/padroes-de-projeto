package eu.padroes_de_projeto.services;

import eu.padroes_de_projeto.model.Client;

public interface ClientService {
    Iterable<Client> selectAll();
    Client selectById(Long id);
    Client insert(Client client);
    Client update(Long id, Client client);
    void delete(Long id);
}
