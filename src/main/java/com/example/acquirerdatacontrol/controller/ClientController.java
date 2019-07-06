package com.example.acquirerdatacontrol.controller;

import com.example.acquirerdatacontrol.services.ClientService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/clientes"})
public class ClientController {

    private ClientService clientService;

    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }

    @GetMapping
    public List findAll(){
        return this.clientService.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody ObjectNode object){
        return clientService.create(object);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity delete(@PathVariable Long id){ return clientService.delete(id);}


}
