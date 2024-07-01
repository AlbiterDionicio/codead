/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.entities;

import com.codeadbackend.codead.entities.Entity;
import com.codeadbackend.codead.entities.templates.DTOs.EntityDTOTemplate;
import com.codeadbackend.codead.entities.templates.DTOs.PropertyDTOTemplate;
import com.codeadbackend.codead.utils.Utils;
import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
public class EntityTemplate {
    private String _package;
    private String _packageDTOsEntities;
    private String className;
    private String classNameCamelCase;
    private String classNameSnakeCase;
    private ArrayList<PropertyEntityTemplate> fields;
    private ArrayList<PropertyEntityTemplate> relations;

    public EntityTemplate(Entity entity) {
        this.className = entity.getName();
        this.classNameCamelCase = Utils.uncapitalizeFirstLetter(this.className);
        this.classNameSnakeCase = Utils.camelCaseToSnakeCase(this.className);
        EntityDTOTemplate entityDTOTemplate = new EntityDTOTemplate();
        entityDTOTemplate.setEntity(entity);
        this.fields = new ArrayList();
        for(PropertyDTOTemplate field : entityDTOTemplate.getFields()){
            PropertyEntityTemplate propertyEntityTemplate = new PropertyEntityTemplate(field);
            this.fields.add(propertyEntityTemplate);
        }
        this.relations = new ArrayList();
        for(PropertyDTOTemplate relation : entityDTOTemplate.getRelations()){
            PropertyEntityTemplate propertyEntityTemplate = new PropertyEntityTemplate(relation);
            this.relations.add(propertyEntityTemplate);
        }
    }
}
