package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.Acquirer;
import com.example.acquirerdatacontrol.model.Client;
import com.example.acquirerdatacontrol.model.Contract;
import com.example.acquirerdatacontrol.repository.ContractRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContractService {

    private ContractRepository contractRepository;

    public ContractService(ContractRepository contractRepository){
        this.contractRepository = contractRepository;
    }

    public List findAll(){
        return this.contractRepository.findAll();
    }

    public ResponseEntity create(@RequestBody Client client, @RequestBody Acquirer acquirer, @RequestBody String establishment){
        Contract contract = new Contract(client, acquirer, establishment);
        this.contractRepository.save(contract);
        return ResponseEntity.ok("Contrato salvo!");
    }

}