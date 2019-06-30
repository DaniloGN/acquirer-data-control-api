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

    @PostMapping
    public ResponseEntity create(@RequestBody ObjectNode object){
        return contractService.create(object);
    }

    @DeleteMapping
    public ResponseEntity delete(@RequestBody ObjectNode id){
       return contractService.delete(id);
    }

}
