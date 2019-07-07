package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.Client;
import com.example.acquirerdatacontrol.repository.ClientRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
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

    public ResponseEntity create(@RequestBody ObjectNode object){
        Client client = new Client(object.get("name").asText());
        this.clientRepository.save(client);
        return ResponseEntity.ok(client);
    }

    public ResponseEntity delete(@PathVariable Long id){
        try{
            this.clientRepository.deleteById(id);
            return ResponseEntity.ok("Cliente removido com sucesso");
        }catch(Exception e){
            return ResponseEntity.badRequest().body("Cliente inválido!");
        }
    }

}
