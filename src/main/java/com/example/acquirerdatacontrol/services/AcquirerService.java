package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.Acquirer;
import com.example.acquirerdatacontrol.repository.AcquirerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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

    public ResponseEntity create(@RequestBody String name){
        Acquirer acquirer = new Acquirer(name);
        this.acquirerRepository.save(acquirer);
        return ResponseEntity.ok("Adquirente "+name+" salvo!");
    }

}