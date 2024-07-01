/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.services;

import com.codeadbackend.codead.entities.Entity;
import com.codeadbackend.codead.entities.Property;
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
public class EntityServiceTemplate {
    private String _package;
    private String _packageEntities;
    private String _packageRepositories;
    private String className;
    private String classNameCamelCase;
    private ArrayList<RelationServiceTemplate> relations;

    public EntityServiceTemplate(Entity entity) {
        this.className = entity.getName();
        this.classNameCamelCase = Utils.uncapitalizeFirstLetter(this.className);
        this.relations = new ArrayList();
        for(Property property : entity.getProperties()){
            if(!property.getType().equals(Property.TYPE_RELATION)){
                continue;
            }
            RelationServiceTemplate relation = new RelationServiceTemplate(property);
            this.relations.add(relation);
        }
    }
}
