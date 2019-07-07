package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.Acquirer;
import com.example.acquirerdatacontrol.model.Client;
import com.example.acquirerdatacontrol.model.Contract;
import com.example.acquirerdatacontrol.model.ContractKey;
import com.example.acquirerdatacontrol.repository.ContractRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
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

    public ResponseEntity create(@RequestBody ObjectNode object){
        ObjectMapper mapper = new ObjectMapper();
        try{
            Client client = mapper.treeToValue(object.get("client"), Client.class);
            Acquirer acquirer = mapper.treeToValue(object.get("acquirer"), Acquirer.class);
            Contract contract = new Contract(client, acquirer, object.get("establishment").toString());
            this.contractRepository.save(contract);
            return ResponseEntity.ok("Contrato salvo!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Dados incompletos!");
        }
    }

    public ResponseEntity delete(@RequestBody ObjectNode object){
        try{
            ContractKey key = new ContractKey(object.get("clientId").asLong(), object.get("acquirerId").asLong());
            this.contractRepository.deleteById(key);
            return ResponseEntity.ok("Contrato deletado!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body("Dados incorretos!");
        }
    }

}