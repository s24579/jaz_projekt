package pl.edu.pjwstk.pizzaplace.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pjwstk.pizzaplace.model.Client;
import pl.edu.pjwstk.pizzaplace.model.service.ClientService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/client")
public class ClientController {
    ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public ResponseEntity<List<Client>> getAllClients(){
        return ResponseEntity.ok(clientService.getAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Client>> getClientById(@PathVariable("id") Long id){
        return ResponseEntity.ok(clientService.getClientById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClientById(@PathVariable("id") Long id){
        clientService.deleteClientById(id);
        return ResponseEntity.ok("usunieto");
    }

    @PostMapping
    public ResponseEntity<Client> createClient(@RequestBody Client client){
        return ResponseEntity.ok(clientService.createClient(client));
    }

    @PutMapping
    public ResponseEntity<Client> updateClient(@RequestBody Client client){
        if (clientService.updateClient(client) != null)
            return new ResponseEntity<>(clientService.updateClient(client), HttpStatus.OK);
        else return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
