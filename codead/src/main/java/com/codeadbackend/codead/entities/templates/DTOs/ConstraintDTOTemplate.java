/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities.templates.DTOs;

import lombok.ToString;
import com.codeadbackend.codead.entities.Constraint;
import com.codeadbackend.codead.entities.Property;
import com.codeadbackend.codead.utils.Utils;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
@ToString
public class ConstraintDTOTemplate {
    public static String NULLABLE_DEFAULT = "true";
    public static String UNIQUE_DEFAULT = "true";
    public static String TIME_DEFAULT = "FutureOrNow";
    public static String MIN_NUMERIC_DEFAULT = "0";
    public static String MAX_NUMERIC_DEFAULT = "0";
    public static String MIN_STRING_DEFAULT = "0";
    public static String MAX_STRING_DEFAULT = "255";
    public static String NOT_BLANK_DEFAULT = "true";
    public static String INTEGER_DEFAULT = "4";
    public static String DECIMAL_DEFAULT = "2";
    
    public static String CONSTRAINT_SIZE = "Size";
    public static String CONSTRAINT_DIGITS = "Digits";

    private String name;
    private String value;
    private String propertyDataType;
    private String constraintDTO;
    private boolean isValid;

    public ConstraintDTOTemplate(Constraint constraint, String propertyDataType) {
        this.name = constraint.getName();
        this.value = constraint.getValue();
        this.propertyDataType = propertyDataType;
        this.isValid = true;
        this.buildConstraintDTO();
    }
    
    public ConstraintDTOTemplate(){
    }

    private void buildConstraintDTO() {
        // relation
        if (this.name.equals(Constraint.NULLABLE)) {
            String _value = this.value;
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.NULLABLE_DEFAULT;
            }
            if (_value.equals("true")) {
                this.constraintDTO = "@Nullable";
            }
            if (_value.equals("false")) {
                this.constraintDTO = "@NotNull";
            }
            return;
        }
        if (this.name.equals(Constraint.UNIQUE)) {
            String _value = this.value;
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.UNIQUE_DEFAULT;
            }
            if (_value.equals("true")) {
                this.constraintDTO = "@Unique";
            }
            if (_value.equals("false")) {
                this.constraintDTO = "";
                this.isValid = false;
            }
            return;
        }
        // field
        if (this.name.equals(Constraint.TIME)) {
            String _value = this.value;
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.TIME_DEFAULT;
            }
            if (_value.equalsIgnoreCase("Future")) {
                this.constraintDTO = "@Future";
            }
            if (_value.equalsIgnoreCase("FutureOrNow")) {
                this.constraintDTO = "@FutureOrPresent";
            }
            if (_value.equalsIgnoreCase("Past")) {
                this.constraintDTO = "@Past";
            }
            if (_value.equalsIgnoreCase("PastOrNow")) {
                this.constraintDTO = "@PastOrPresent";
            }
            return;
        }
        if (this.name.equals(Constraint.MIN) && this.propertyDataType.equalsIgnoreCase("String")) {
            String _value = Utils.cleanString(this.value, "-");
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.MIN_STRING_DEFAULT;
            }
            this.constraintDTO = "@Size(min = " + _value + ")";
            return;
        }
        if (this.name.equals(Constraint.MAX) && this.propertyDataType.equalsIgnoreCase("String")) {
            String _value = Utils.cleanString(this.value, "-");
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.MAX_STRING_DEFAULT;
            }
            this.constraintDTO = "@Size(max = " + _value + ")";
            return;
        }
        if (this.name.equals(Constraint.NOT_BLANK)) {
            String _value = this.value;
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.NOT_BLANK_DEFAULT;
            }
            if (_value.equalsIgnoreCase("true")) {
                this.constraintDTO = "@NotBlank";
            }
            if (_value.equalsIgnoreCase("false")) {
                this.constraintDTO = "";
                this.isValid = false;
            }
            return;
        }
        if (this.name.equals(Constraint.MIN) && !this.propertyDataType.equalsIgnoreCase("String")) {
            String _value = this.value;
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.MIN_NUMERIC_DEFAULT;
            }
            this.constraintDTO = "@Min(" + _value + ")";
            return;
        }
        if (this.name.equals(Constraint.MAX) && !this.propertyDataType.equalsIgnoreCase("String")) {
            String _value = this.value;
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.MAX_NUMERIC_DEFAULT;
            }
            this.constraintDTO = "@Max(" + _value + ")";
            return;
        }
        if (this.name.equals(Constraint.INTEGER)) {
            String _value = Utils.cleanString(this.value, "-");
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.INTEGER_DEFAULT;
            }
            this.constraintDTO = "@Digits(integer = " + _value + ")";
            return;
        }
        if (this.name.equals(Constraint.DECIMAL)) {
            String _value = Utils.cleanString(this.value, "-");
            if (_value == null || _value.isEmpty()) {
                _value = ConstraintDTOTemplate.DECIMAL_DEFAULT;
            }
            this.constraintDTO = "@Digits(fraction = " + _value + ")";
        }
    }

    public boolean getIsValid() {
        return this.isValid;
    }

    public static ArrayList<ConstraintDTOTemplate> fix(ArrayList<ConstraintDTOTemplate> constraints) {
        Map<String, ConstraintDTOTemplate> map = new LinkedHashMap<>();
        for(ConstraintDTOTemplate constraint :constraints){
            map.put(constraint.getName(), constraint);
        }
        ArrayList<ConstraintDTOTemplate> uniqueAndLastConstraints = new ArrayList<>(map.values());
        
        ArrayList<ConstraintDTOTemplate> validConstraints = new ArrayList();
        ArrayList<ConstraintDTOTemplate> sizeConstraints = new ArrayList();
        ArrayList<ConstraintDTOTemplate> digitsConstraints = new ArrayList();
        
        for (ConstraintDTOTemplate constraint : uniqueAndLastConstraints) {
            if (constraint.getIsValid()) {
                if (constraint.getPropertyDataType().equalsIgnoreCase("String")
                        && (constraint.getName().equalsIgnoreCase(Constraint.MIN)
                        || constraint.getName().equalsIgnoreCase(Constraint.MAX))) {
                    sizeConstraints.add(constraint);
                    continue;
                }
                if (constraint.getName().equalsIgnoreCase(Constraint.INTEGER)
                        || constraint.getName().equalsIgnoreCase(Constraint.DECIMAL)) {
                    digitsConstraints.add(constraint);
                    continue;
                }
                validConstraints.add(constraint);
            }
        }
        
        if(sizeConstraints.size() >= 1){
            ArrayList<String> sizeConstraintsKeys = new ArrayList();
            
            for(ConstraintDTOTemplate constraintDTOTemplate : sizeConstraints){
                String contentOfParenthesis = ConstraintDTOTemplate.getContentOfParenthesis(constraintDTOTemplate.getConstraintDTO());
                sizeConstraintsKeys.add(contentOfParenthesis);    
            }
            String constraintDTO = "@Size(" + String.join(", ", sizeConstraintsKeys) + ")";
            
            ConstraintDTOTemplate sizeConstraint  = new ConstraintDTOTemplate();
            sizeConstraint.setValid(true);
            sizeConstraint.setName(ConstraintDTOTemplate.CONSTRAINT_SIZE);
            sizeConstraint.setConstraintDTO(constraintDTO);
            
            validConstraints.add(sizeConstraint);
        }
        
        if(digitsConstraints.size() >= 1){
            String _integer = ConstraintDTOTemplate.INTEGER_DEFAULT;
            String _fraction = ConstraintDTOTemplate.DECIMAL_DEFAULT;
            
            for(ConstraintDTOTemplate constraintDTOTemplate : digitsConstraints){
                if(constraintDTOTemplate.getConstraintDTO().contains("integer")){
                    _integer = ConstraintDTOTemplate.getContentOfParenthesis(constraintDTOTemplate.getConstraintDTO());
                }
                if(constraintDTOTemplate.getConstraintDTO().contains("fraction")){
                    _fraction = ConstraintDTOTemplate.getContentOfParenthesis(constraintDTOTemplate.getConstraintDTO());
                }
            }
            
            String constraintDTO = "@Digits("+_integer + ", " + _fraction + ")";

            ConstraintDTOTemplate digitsConstraint  = new ConstraintDTOTemplate();
            digitsConstraint.setValid(true);
            digitsConstraint.setName(ConstraintDTOTemplate.CONSTRAINT_DIGITS);
            digitsConstraint.setConstraintDTO(constraintDTO);
            
            validConstraints.add(digitsConstraint);
        }
        
        return validConstraints;
    }
    
    public static String getContentOfParenthesis(String content){
        Pattern pattern = Pattern.compile("\\(([^\\)]+)\\)");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }
}
