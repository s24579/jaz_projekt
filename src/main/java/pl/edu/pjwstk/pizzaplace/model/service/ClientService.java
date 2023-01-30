package pl.edu.pjwstk.pizzaplace.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pjwstk.pizzaplace.model.Client;
import pl.edu.pjwstk.pizzaplace.repository.ClientRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ClientService {
    ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long id){
        return clientRepository.findById(id);
    }

    public void deleteClientById(Long id){
        clientRepository.deleteById(id);
    }

    public Client updateClient(Client client) {
        if (clientRepository.findById(client.getId()).isPresent())
            return clientRepository.save(client);
        return null;
    }

}
