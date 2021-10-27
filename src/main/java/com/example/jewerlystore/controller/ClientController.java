package com.example.jewerlystore.controller;

import com.example.jewerlystore.model.Client;
import com.example.jewerlystore.request.ClientCreationRequest;
import com.example.jewerlystore.request.UpdateClientNameRequest;
import com.example.jewerlystore.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@Validated
public class ClientController {
    @Autowired
    ClientService clientService;
    @GetMapping
    public List<Client> getClient(){
        return clientService.findAll();
    }
    @GetMapping
    public Client getClientById(@PathVariable Long id){
        return clientService.getClientsById(id);
    }
    @PostMapping
    public List<Client> createClient(@RequestBody @Valid List<ClientCreationRequest>clientCreationRequest){
        return clientService.createClient(clientCreationRequest);
    }
    @PutMapping
    public Client updateClientName(@PathVariable(value = "id")Long id, @RequestBody UpdateClientNameRequest updateClientNameRequest){
        return clientService.updateClient(id, updateClientNameRequest.getName());
    }
    @DeleteMapping
    public void deleteById(@PathVariable(value = "id")Long id){clientService.deleteById(id);}
}
