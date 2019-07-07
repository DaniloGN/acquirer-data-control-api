package com.example.acquirerdatacontrol.controller;

import com.example.acquirerdatacontrol.services.ContractService;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
