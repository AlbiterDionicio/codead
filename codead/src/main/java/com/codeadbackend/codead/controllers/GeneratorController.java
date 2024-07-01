/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.controllers;

import com.codeadbackend.codead.daos.ResponseDao;
import com.codeadbackend.codead.daos.SchemaDao;
import com.codeadbackend.codead.services.GeneratorService;
import com.codeadbackend.codead.services.DownloadService;
import freemarker.template.TemplateException;
import jakarta.validation.Valid;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DAVID
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api")
public class GeneratorController {
    @Autowired
    GeneratorService generatorService;
    
    @Autowired
    DownloadService downloadService;
    
    @PostMapping("/generate")
    public void generate(@Valid @RequestBody SchemaDao schemaDao) throws IOException, TemplateException {
        this.generatorService.generate(schemaDao);
    }

    @GetMapping("/download")
    public ResponseEntity<byte[]> download(
            @RequestParam(required = false) String schemaId,
            @RequestParam(required = false) String createdAt,
            @RequestParam(required = false, defaultValue = DownloadService.DEFAULT_ZIP_NAME) String zipName
    ){
        ResponseDao responseDao = this.downloadService.process(schemaId, createdAt);
        if(responseDao.isError()){
            ResponseEntity
                    .status(HttpStatusCode.valueOf(responseDao.getStatusHttp()));
        }
        
        zipName = DownloadService.addExtension(zipName);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", zipName);
        return ResponseEntity
                .status(HttpStatusCode.valueOf(responseDao.getStatusHttp()))
                .headers(headers)
                .body(responseDao.getZip());
    }
}
