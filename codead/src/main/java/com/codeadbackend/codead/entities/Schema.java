/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import java.util.ArrayList;
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
public class Schema {
    private String id;
    private Metadata metadata;
    private Profile profile;
    private ArrayList<Entity> entities;
    private long createdAt;
    
    public Schema(){
        this.createdAt = System.currentTimeMillis();
    }
}
