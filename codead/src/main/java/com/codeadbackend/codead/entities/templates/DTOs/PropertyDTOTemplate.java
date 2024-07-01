/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.DTOs;

import java.util.ArrayList;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import com.codeadbackend.codead.entities.Property;
import com.codeadbackend.codead.utils.Utils;
import com.codeadbackend.codead.entities.Constraint;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
@ToString
public class PropertyDTOTemplate {
    private String type;
    private String dataType;
    private String dataTypeCamelCase;
    private String identifier;
    private String identifierCamelCase;
    private String identifierPascalCase;
    private String _setIdentifier;
    private String _getIdentifier;
    private ArrayList<ConstraintDTOTemplate> constraints;
    
    public PropertyDTOTemplate(Property property){
        this.type = property.getType();
        if(property.getDataType().equalsIgnoreCase("boolean")){
            this.dataType = "Boolean";
        }else{
            this.dataType = property.getDataType();
        }
        this.dataTypeCamelCase = Utils.uncapitalizeFirstLetter(this.dataType);
        this.identifier = property.getIdentifier();
        this.identifierCamelCase = Utils.uncapitalizeFirstLetter(this.identifier);
        this.identifierPascalCase = Utils.capitalizeFirstLetter(this.identifier);
        this._setIdentifier = "set" + this.identifierPascalCase;
        this._getIdentifier = "get" + this.identifierPascalCase;
        this.constraints = new ArrayList();
        for (Constraint constraint : property.getConstraints()) {
            ConstraintDTOTemplate constraintDTOTemplate = new ConstraintDTOTemplate(constraint, this.dataType);
            this.constraints.add(constraintDTOTemplate);
        }
        this.constraints = ConstraintDTOTemplate.fix(this.constraints);
    }
}
