/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.services.errors;

/**
 *
 * @author DAVID
 */
public class DownloadInputError extends RuntimeException {
    public DownloadInputError(String message){
        super(message);
    }
}
