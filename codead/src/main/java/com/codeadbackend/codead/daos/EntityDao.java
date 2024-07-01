/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.daos;

import com.codeadbackend.codead.entities.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class EntityDao {
    @NotBlank(message = "Nombre debe tener al menos 1 caracter.")
    @NotNull(message = "Nombre es requerido.")
    private String name;
    @NotBlank(message = "Contenido debe tener al menos 1 caracter.")
    @NotNull(message = "Contenido es requerido.")
    private String content;
    
    public Entity asEntity(){
        return new Entity(this.name,this.content);
    }
}
