/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import java.util.ArrayList;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Property {
    public static final String TYPE_FIELD = "field";
    public static final String TYPE_RELATION = "relation";
    
    private String type;
    private String dataType;
    private String identifier;
    private ArrayList<Constraint> constraints;
}
