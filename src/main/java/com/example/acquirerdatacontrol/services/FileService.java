package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.File;
import com.example.acquirerdatacontrol.repository.FileRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
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

    public ResponseEntity findById(@PathVariable long id){
        return fileRepository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    public List<File> create(@RequestBody MultipartFile file){
        List<File> files = new ArrayList<>();
        try {
            String line;
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while ((line = bufferReader.readLine()) != null){
                if(line.contains("UflaCard")){
                    files.add(new File(
                            line.charAt(0),
                            line.substring(1,11),
                            line.substring(11,19),
                            line.substring(19,27),
                            line.substring(27,35),
                            line.substring(35,42),
                            line.substring(42,50)
                    ));
                }
                else if(line.contains("FagammonCard")){
                    files.add(new File(
                            line.charAt(0),
                            line.substring(1,9),
                            line.substring(9,17),
                            line.substring(17,29),
                            line.substring(29,36)
                    ));
                }
            }
        } catch(IOException e){
            System.err.println(e.getMessage());
        }
        fileRepository.saveAll(files);
        return files;
    }
}
