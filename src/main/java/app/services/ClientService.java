package app.services;

import app.entities.ClientsEntity;
import app.repos.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    public ClientRepository clientRepository;

    public List<ClientsEntity> getAllClients() {

        List<ClientsEntity> clients = new ArrayList<ClientsEntity>();
        clientRepository.findAll().forEach(clients::add);
        return clients;
    }

    public Optional<ClientsEntity> getClientById(int id) {
        return clientRepository.findById(id);
    }

    public void updateClientById(int id, ClientsEntity client) {
        clientRepository.save(client);
    }

    public void deleteClient(int id) {
        clientRepository.deleteById(id);
    }

    public void saveClient(ClientsEntity client) {
        clientRepository.save(client);
    }
}
