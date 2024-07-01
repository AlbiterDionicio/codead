/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.DTOs;

import com.codeadbackend.codead.entities.Property;
import com.codeadbackend.codead.entities.Entity;
import com.codeadbackend.codead.utils.Utils;
import java.util.ArrayList;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.ToString;

/**
 *
 * @author DAVID
 */
@Getter
@ToString
public class EntityDTOTemplate {
    private String _package;
    private String _packageEntities;
    private String _packageDTOsEntities;
    private String className;
    private String classNameCamelCase;
    private ArrayList<PropertyDTOTemplate> fields;
    private ArrayList<PropertyDTOTemplate> relations;
    
    public void set_package(String _package){
        this._package = _package;
    }
    
    public void set_packageEntities(String _packageEntities){
        this._packageEntities = _packageEntities;
    }
    
    public void set_packageDTOsEntities(String _packageDTOsEntities){
        this._packageDTOsEntities = _packageDTOsEntities;
    }
    
    public void setEntity(Entity entity){
        this.className = entity.getName();
        this.classNameCamelCase = Utils.uncapitalizeFirstLetter(entity.getName());
        ArrayList<PropertyDTOTemplate> propertiesDTOTemplate = new ArrayList<>();
        for(Property property : entity.getProperties()){
            PropertyDTOTemplate propertyDTOTemplate = new PropertyDTOTemplate(property);
            propertiesDTOTemplate.add(propertyDTOTemplate);
        }
        this.fields = new ArrayList<>(
                propertiesDTOTemplate
                        .stream()
                        .filter(property -> property.getType().equals(Property.TYPE_FIELD))
                        .collect(Collectors.toList())
        );
        this.relations = new ArrayList<>(
                propertiesDTOTemplate
                        .stream()
                        .filter(property -> property.getType().equals(Property.TYPE_RELATION))
                        .collect(Collectors.toList())
        );
    }
}
