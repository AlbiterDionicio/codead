/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Log {    
    public static final String STARTING = "la generación del backend ha comenzado";
    public static final String GENERATING_TREE_FILE = "árbol de archivos generado";
    public static final String CLONATION_STATIC_FILES = "clonación de archivos estáticos terminada";
    public static final String GENERATING_MAIN = "clases main generadas";
    public static final String GENERATING_CONFIGURATION_FILES = "archivos de configuración generados";
    public static final String GENERATING_DTOS = "DTOs generado";
    public static final String GENERATING_CONTROLLERS = "controlador generado";
    public static final String GENERATING_SERVICES = "servicio generado";
    public static final String GENERATING_REPOSITORIES = "repositorio generado";
    public static final String GENERATING_ENTITIES = "entidad generada";
    public static final String GENERATING_SPECIFICATION = "especificación generada";
    public static final String ENDING = "generación del backend terminado";
    
    private String schemaId;
    private long schemaCreatedAt;
    private String name;
    private String message;
    private long miliseconds;
    
    public String asJSON() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            String logJSON = mapper.writeValueAsString(this);
            return logJSON;
        } catch (Exception e) {
            System.out.println("Eception in Log class");
            System.out.println(e);
        }
        return "error";
    }
}
