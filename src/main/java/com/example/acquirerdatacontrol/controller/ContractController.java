package com.example.acquirerdatacontrol.controller;

import com.example.acquirerdatacontrol.model.Acquirer;
import com.example.acquirerdatacontrol.model.Client;
import com.example.acquirerdatacontrol.services.ContractService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jdk.nashorn.internal.runtime.regexp.joni.constants.NodeType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping({"/contratos"})
public class ContractController {

    private ContractService contractService;

    public ContractController(ContractService contractService){
        this.contractService = contractService;
    }

    @GetMapping
    public List findAll(){
        return this.contractService.findAll();
    }

//    @PostMapping
//    public ResponseEntity create(@RequestBody Map<String, Object> json){
//        System.out.println(json.get("client"));
//        Client client = new Client(json.get("client.id"),json.get("client.name"));
//        return contractService.create(json.get("client"), json.get("acquirer"), json.get("establishment"));
//    }

    @PostMapping
    public ResponseEntity create(@RequestBody ObjectNode object){
        ObjectMapper mapper = new ObjectMapper();
        try{
            Client client = mapper.treeToValue(object.get("client"), Client.class);
            Acquirer acquirer = mapper.treeToValue(object.get("acquirer"), Acquirer.class);
            return contractService.create(client, acquirer, object.get("establishment").toString());
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Dados incompletos!");
        }
    }

}
