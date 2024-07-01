/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.repositories;

import com.codeadbackend.codead.entities.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
public class EntityRepositoryTemplate {
    private String _package;
    private String _packageEntities;
    private String className;

    public EntityRepositoryTemplate(Entity entity) {
        this.className = entity.getName();
    }
}
