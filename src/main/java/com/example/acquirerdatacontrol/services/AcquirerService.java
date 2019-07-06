package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.Acquirer;
import com.example.acquirerdatacontrol.repository.AcquirerRepository;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class AcquirerService {

    private AcquirerRepository acquirerRepository;

    public AcquirerService(AcquirerRepository acquirerRepository){
        this.acquirerRepository = acquirerRepository;
    }

    public List findAll(){
        return this.acquirerRepository.findAll();
    }

    public ResponseEntity create(@RequestBody ObjectNode object){
        Acquirer acquirer = new Acquirer(object.get("name").asText());
        this.acquirerRepository.save(acquirer);
        return ResponseEntity.ok(acquirer);
    }

    public ResponseEntity delete(@PathVariable Long id) {
        try {
            this.acquirerRepository.deleteById(id);
            return ResponseEntity.ok("Adquirente removido com sucesso");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Adquirente inválido!");
        }
    }

}