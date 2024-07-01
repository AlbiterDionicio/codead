/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.controllers;

import com.codeadbackend.codead.entities.Entity;
import com.codeadbackend.codead.utils.Utils;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
public class EntityControllerTemplate {
    private String _package;
    private String _packageDTOsEntities;
    private String _packageEntities;
    private String className;
    private String classNameCamelCase;
    private String endPoint;

    public EntityControllerTemplate(Entity entity) {
        this.className = entity.getName();
        this.classNameCamelCase = Utils.uncapitalizeFirstLetter(this.className);
        this.endPoint = Utils.camelCaseToSnakeCase(
            Utils.pluralize(this.className)
        );
    }
}
