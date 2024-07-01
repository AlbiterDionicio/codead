/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.daos;

import java.io.File;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
public class ResponseDao {
    public static final int ERROR_USER_CODE = 400;
    public static final int ERROR_SYSTEM_CODE = 500;
    public static final int SUCCESS_USER_CODE = 200;
    
    private byte[] zip;
    private String message;
    private boolean error;
    private int statusHttp;
    
    public void setError(int code){
        this.statusHttp = code;
        if(code == ResponseDao.ERROR_USER_CODE){
            this.error = true;
            this.message = "User error, check metadata, profile or entities and then try again";
        }
        if(code == ResponseDao.ERROR_USER_CODE){
            this.error = true;
            this.message = "Internal server error, try again";
        }
    }
    
    public void setSuccess(){
        this.error = false;
        this.statusHttp = ResponseDao.SUCCESS_USER_CODE;
        this.message = "Empaquetado en formato zip exitoso";
    }
}
