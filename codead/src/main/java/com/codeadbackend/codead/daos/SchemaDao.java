/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.daos;

import com.codeadbackend.codead.entities.Entity;
import com.codeadbackend.codead.entities.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.stream.Collectors;
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
public class SchemaDao {
    @NotBlank
    @NotNull
    private String id;
    @NotNull(message = "Metadata es requerida.")
    @Valid
    private MetadataDao metadata;
    @NotNull(message = "Perfil es requerido.")
    @Valid
    private ProfileDao profile;
    @NotEmpty(message = "Entidades son requeridas y al menos debe tener un elemento.")
    @Valid
    private ArrayList<EntityDao> entities;
    
    public Schema asEntity(){
        Schema schema = new Schema();
        schema.setId(this.id);
        schema.setMetadata(this.metadata.asEntity());
        schema.setProfile(this.profile.asEntity());
        ArrayList<Entity> entities = this.entities.stream().map(EntityDao::asEntity).collect(Collectors.toCollection(ArrayList::new));
        schema.setEntities(entities);
        return schema;
    }
}
