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
    @GetMapping("/clients")
    public List<Client> getClientById(){
        return clientService.findAll();
    }
    @GetMapping("/clients{id}")
    public Client getClientById(@PathVariable Long id){
        return clientService.getClientById(id);
    }
    @PostMapping(value = "/clients")
    public List<Client> createClient(@RequestBody @Valid List<ClientCreationRequest>clientCreationRequest){
        return clientService.createClient(clientCreationRequest);
    }
    @PutMapping(value = "/client-update{id}")
    public Client updateClientName(@PathVariable(value = "id")Long id, @RequestBody UpdateClientNameRequest updateClientNameRequest){
        return clientService.updateClient(id, updateClientNameRequest.getName());
    }
    @DeleteMapping(value = "/client-delete{id}")
    public void deleteById(@PathVariable(value = "id")Long id){clientService.deleteClientById(id);}
}
