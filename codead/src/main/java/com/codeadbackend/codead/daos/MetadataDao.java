/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.daos;

import com.codeadbackend.codead.entities.Metadata;
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
public class MetadataDao {
    @NotBlank(message = "Grupo debe tener al menos 1 caracter.")
    @NotNull(message = "Grupo es requerido.")
    private String group;
    @NotBlank(message = "Artefacto debe tener al menos 1 caracter.")
    @NotNull(message = "Artefacto es requerido.")
    private String artifact;
    @NotBlank(message = "Nombre debe tener al menos 1 caracter.")
    @NotNull(message = "Nombre es requerido.")
    private String name;
    private String description;
    @NotBlank(message = "Paquete debe tener al menos 1 caracter.")
    @NotNull(message = "Paquete es requerido.")
    private String _package;

    public Metadata asEntity() {
        Metadata metadata = new Metadata();
        metadata.setGroup(this.group);
        metadata.setArtifact(this.artifact);
        metadata.setName(this.name);
        metadata.setDescription(this.description);
        metadata.set_package(this._package);
        return metadata;
    }
}
