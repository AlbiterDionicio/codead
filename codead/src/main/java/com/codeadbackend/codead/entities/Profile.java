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
public class Profile {
    private String url;
    private String user;
    private String password;
    private String ddl;
    private String port;
}
