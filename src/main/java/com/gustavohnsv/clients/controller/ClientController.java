package com.gustavohnsv.clients.controller;

import com.gustavohnsv.clients.exception.ResourceNotFoundException;
import com.gustavohnsv.clients.model.Client;
import com.gustavohnsv.clients.model.Message;
import com.gustavohnsv.clients.repository.ClientRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/clients/")
public class ClientController {

    private final ClientRepository clientRepository;

    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping("/{id}")
    public Client getClient(@PathVariable String id) {
        return clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with id: " + id));
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @PatchMapping("/")
    public Client updateClient(@RequestParam String id, @RequestBody Map<String, Object> request) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with: " + id));
        if (request.containsKey("firstName")) {
            client.setFirstName((String) request.get("firstName"));
        } if (request.containsKey("lastName")) {
            client.setLastName((String) request.get("lastName"));
        } if (request.containsKey("gender")) {
            client.setGender((String) request.get("gender"));
        } if (request.containsKey("age")) {
            client.setAge((Integer) request.get("age"));
        } if (request.containsKey("email")) {
            client.setEmail((String) request.get("email"));
        } if (request.containsKey("address")
        ) {
            client.setAddress((String) request.get("address"));
        }
        return clientRepository.save(client);
    }

    @DeleteMapping("/")
    public Message deleteClient(@RequestParam String id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Client not found with: " + id));
        clientRepository.delete(client);
        return new Message("success", "Client deleted with success!");
    }

}
