/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
@ToString
public class Constraint {
    public static String NOT_BLANK = "notBlank";
    public static String TIME = "time";
    public static String DECIMAL = "decimal";
    public static String INTEGER = "integer";
    public static String MAX = "max";
    public static String MIN = "min";
    public static String NULLABLE = "nullable";
    public static String UNIQUE = "unique";
    
    private String name;
    private String value;
}
