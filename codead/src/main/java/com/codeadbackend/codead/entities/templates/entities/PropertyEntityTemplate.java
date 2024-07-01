/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.entities;

import com.codeadbackend.codead.entities.templates.DTOs.PropertyDTOTemplate;
import com.codeadbackend.codead.utils.Utils;
import com.codeadbackend.codead.entities.Property;
import com.codeadbackend.codead.entities.templates.DTOs.ConstraintDTOTemplate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
public class PropertyEntityTemplate {

    public static final String MANY_TO_ONE = "@ManyToOne";
    public static final String JOIN_COLUMN = "@JoinColumn";
    public static final String COLUMN = "@Column";

    private String dataType;
    private String identifier;
    private String _getIdentifier;
    private String _setIdentifier;
    private String column;
    private String manyToOne;
    private String joinColumn;

    PropertyEntityTemplate(PropertyDTOTemplate property) {
        if(property.getDataType().equalsIgnoreCase("boolean")){
            this.dataType = "Boolean";
        }else{
            this.dataType = property.getDataType();    
        }
        this.identifier = property.getIdentifier();
        String identifierPascalCase = Utils.capitalizeFirstLetter(this.identifier);
        this._getIdentifier = "get" + identifierPascalCase;
        this._setIdentifier = "set" + identifierPascalCase;
        if (property.getType().equalsIgnoreCase(Property.TYPE_FIELD)) {
            this.buildColumn(property.getConstraints());
        }
        if (property.getType().equalsIgnoreCase(Property.TYPE_RELATION)) {
            this.buildRelation(property.getConstraints());
        }
    }

    private void buildColumn(ArrayList<ConstraintDTOTemplate> constraints) {
        Set<String> keys = new HashSet();
        for (ConstraintDTOTemplate constraint : constraints) {
            if (constraint.getConstraintDTO().contains("@NotNull")) {
                keys.add("nullable = false");
            }
            if (constraint.getConstraintDTO().contains("@Unique")) {
                keys.add("unique = true");
            }
            if (this.dataType.equalsIgnoreCase("string")
                    && constraint.getConstraintDTO().contains("@Size")) {
                Pattern pattern = Pattern.compile("\\b(max)\\s*=\\s*(\\d+)");
                Matcher matcher = pattern.matcher(constraint.getConstraintDTO());
                while(matcher.find()){
                    String number = matcher.group(2);
                    keys.add("length = " + number);
                }
            }
            if(this.dataType.equalsIgnoreCase("string")
                    && constraint.getConstraintDTO().contains("@NotBlank")){
                keys.add("nullable = false");
            }
        }

        String keysAsString = String.join(", ", keys);
        if(this.dataType.equalsIgnoreCase("String") && !keysAsString.contains("length")){
            keys.add("length = " + ConstraintDTOTemplate.MAX_STRING_DEFAULT);
        }
        
        keysAsString = String.join(", ", keys);
        this.column = PropertyEntityTemplate.COLUMN + "(" + keysAsString + ")";
    }

    private void buildRelation(ArrayList<ConstraintDTOTemplate> constraints) {
        boolean addedRelation = false;
        for (ConstraintDTOTemplate constraint : constraints) {
            if (constraint.getConstraintDTO().contains("@NotNull")) {
                this.manyToOne = PropertyEntityTemplate.MANY_TO_ONE + "(optional = false)";
                addedRelation = true;
            }
            if (constraint.getConstraintDTO().contains("@Unique")) {
                this.joinColumn = PropertyEntityTemplate.JOIN_COLUMN + "(unique = true)";
            }
        }
        if (!addedRelation) {
            this.manyToOne = PropertyEntityTemplate.MANY_TO_ONE;
        }
    }
}
