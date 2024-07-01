/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.daos;

import com.codeadbackend.codead.entities.Profile;
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
public class ProfileDao {
    @NotBlank(message = "Url debe tener al menos 1 caracter.")
    @NotNull(message = "Url es requerida.")
    private String url;
    @NotBlank(message = "Usuario debe tener al menos 1 caracter.")
    @NotNull(message = "Usuario es requerido.")
    private String user;
    private String password;
    @NotBlank(message = "DDL debe tener al menos 1 caracter.")
    @NotNull(message = "DDL es requerido.")
    private String ddl;
    @NotBlank(message = "Puerto debe tener al menos 1 caracter.")
    @NotNull(message = "Puerto es requerido.")
    private String port;

    public Profile asEntity() {
        Profile profile = new Profile();
        profile.setUrl(this.url);
        profile.setUser(this.user);
        profile.setPassword(this.password);
        profile.setDdl(this.ddl);
        profile.setPort(this.port);
        return profile;
    }
}
