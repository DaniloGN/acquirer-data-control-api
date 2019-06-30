package com.example.acquirerdatacontrol.controller;

import com.example.acquirerdatacontrol.services.FileService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping({"/arquivos"})
public class FileController {

    private FileService fileService;

    public FileController(FileService fileService){
        this.fileService = fileService;
    }

    @GetMapping
    public List findAll(){
        return this.fileService.findAll();
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity findById(@PathVariable long id){
        return fileService.findById(id);
    }

    @PutMapping(path = {"/estado/{id}"})
    public ResponseEntity updateStatus(@PathVariable long id, @RequestBody String status) {
        return fileService.updateFileStatus(id, status);
    }

    @GetMapping(path = {"download/{id}"})
    public ResponseEntity downloadFile(@PathVariable long id){
        return fileService.downloadAcquirerFile(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity create(@RequestBody MultipartFile file){
        return fileService.create(file);
    }

}
