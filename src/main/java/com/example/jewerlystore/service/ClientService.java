package com.example.jewerlystore.service;

import com.example.jewerlystore.model.Client;

import com.example.jewerlystore.repository.ClientRepository;
import com.example.jewerlystore.request.ClientCreationRequest;
import com.example.jewerlystore.request.JewelCreationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientService {
    ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository){this.clientRepository=clientRepository;}
    //finding all our clients
    public List<Client> findAll(){return clientRepository.findAll();}
    //get clients by id
    public Client getClientsById(Long id){return clientRepository.findById(id);}
    //create new client

    public List<Client> createClient(List<ClientCreationRequest> clientCreationRequestList){
        List<Client> newclientList = new ArrayList<>();
        Client newClient;
        for (ClientCreationRequest clientCreationRequest:clientCreationRequestList){
            newClient=Client.builder()
                    .name(clientCreationRequest.getName())
                    .build();
            clientRepository.save(newClient);
            newclientList.add(newClient);
        }
        return newclientList;
    }
    //update client by name
    public Client updateClient(Long id, String name) {
        Client clientToUpdate=this.getClientsById(id);
        clientToUpdate.setName(name);
        clientRepository.save(clientToUpdate);
        return clientToUpdate;
    }
    //delete by id
    public void deleteById(Long id) {
        this.getClientsById(id);
        clientRepository.deleteById(String.valueOf(id));
    }
}
