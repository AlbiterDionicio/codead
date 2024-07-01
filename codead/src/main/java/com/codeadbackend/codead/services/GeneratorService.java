/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.services;

import com.codeadbackend.codead.daos.SchemaDao;
import com.codeadbackend.codead.entities.Composer;
import com.codeadbackend.codead.entities.Schema;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAVID
 */
@Service
@Scope("prototype")
public class GeneratorService {
    @Autowired Composer composer;
    
    public void generate(SchemaDao schemaDao) throws IOException {
        Schema schema = schemaDao.asEntity();
        composer.start(schema);
    }
}
