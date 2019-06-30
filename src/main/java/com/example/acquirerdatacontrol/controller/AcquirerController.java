package com.example.acquirerdatacontrol.controller;

import com.example.acquirerdatacontrol.services.AcquirerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/adquirentes"})
public class AcquirerController {

    private AcquirerService acquirerService;

    public AcquirerController(AcquirerService acquirerService){
        this.acquirerService = acquirerService;
    }

    @GetMapping
    public List findAll(){
        return this.acquirerService.findAll();
    }

    @PostMapping
    public ResponseEntity create(@RequestBody String name){
        return acquirerService.create(name);
    }

}