package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.File;
import com.example.acquirerdatacontrol.repository.FileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileReader;
import java.io.InputStream;
import java.util.List;

@Service
public class FileService {

    private FileRepository fileRepository;

    public FileService(FileRepository fileRepository){
        this.fileRepository = fileRepository;
    }

    public List findAll(){
        return this.fileRepository.findAll();
    }
    
}
