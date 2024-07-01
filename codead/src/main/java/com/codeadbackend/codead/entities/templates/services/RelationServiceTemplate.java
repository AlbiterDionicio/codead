/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.services;

import com.codeadbackend.codead.entities.Property;
import com.codeadbackend.codead.utils.Utils;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
public class RelationServiceTemplate {
    private String dataType;
    private String dataTypeCamelCase;
    private String identifier;
    private String identifierCamelCase;
    private String _setIdentifier;
    private String _getIdentifier;

    RelationServiceTemplate(Property property) {
        this.dataType = property.getDataType();
        this.dataTypeCamelCase = Utils.uncapitalizeFirstLetter(property.getDataType());
        this.identifier = property.getIdentifier();
        this.identifierCamelCase = Utils.capitalizeFirstLetter(this.identifier);
        String identifierPascalCase = Utils.capitalizeFirstLetter(this.identifier);
        this._setIdentifier = "set" + identifierPascalCase;
        this._getIdentifier = "get" + identifierPascalCase;
    }
}
