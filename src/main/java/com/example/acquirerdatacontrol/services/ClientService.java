package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.Client;
import com.example.acquirerdatacontrol.repository.ClientRepository;
import com.example.acquirerdatacontrol.repository.FileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
            this.clientRepository = clientRepository;
        }

    public List findAll(){
       return this.clientRepository.findAll();
    }

    public ResponseEntity create(@RequestBody String name){
        Client client = new Client(name);
        this.clientRepository.save(client);
        return ResponseEntity.ok("Cliente "+name+" salvo!");
    }

}
