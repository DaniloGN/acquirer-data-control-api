package com.example.acquirerdatacontrol.services;

import com.example.acquirerdatacontrol.model.File;
import com.example.acquirerdatacontrol.repository.FileRepository;
import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public ResponseEntity create(@RequestBody MultipartFile file){
        List<File> files = new ArrayList<>();
        try {
            String line;
            BufferedReader bufferReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
            while ((line = bufferReader.readLine()) != null){
                if(line.contains("UflaCard") && line.length()== 50){
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
                else if(line.contains("FagammonCard") && line.length()==36){
                    files.add(new File(
                            line.charAt(0),
                            line.substring(1,9),
                            line.substring(9,17),
                            line.substring(17,29),
                            line.substring(29,36)
                    ));
                }
                else{
                    return ResponseEntity.badRequest().body("Dados incorretos no arquivo!");
                }
            }
        } catch(IOException e){
            return ResponseEntity.badRequest().body("Dados incorretos no arquivo!");
        }
        fileRepository.saveAll(files);
        return ResponseEntity.ok("Dados salvos!");
    }

    public ResponseEntity downloadAcquirerFile(@RequestParam Long id) {
        Optional<File> optionalFile = fileRepository.findById(id);
        if (optionalFile.isPresent()) {
            File file = optionalFile.get();
            String pathName = file.getAcquirer_name() + "_" + file.getEstablishment();
            byte[] fileByte = file.getAcquirer_name().equals("FagammonCard") ? file.faggamonCard().getBytes(Charset.forName("UTF-8")) : file.uflaCard().getBytes(Charset.forName("UTF-8"));
            InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(fileByte));
                MediaType mediaType = MediaType.parseMediaType("application/txt");
                return ResponseEntity.ok()
                        .header("Content-Disposition", "attachment;filename=" + pathName+".txt")
                        .contentType(mediaType)
                        .body(resource);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Arquivo não encontrado!");
        }
    }
}
