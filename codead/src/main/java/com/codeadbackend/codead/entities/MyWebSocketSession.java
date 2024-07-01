/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.socket.WebSocketSession;

/**
 *
 * @author DAVID
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyWebSocketSession {
    public static final String FRONTEND_ID = "frontendId";
    
    private String frontendId;
    private WebSocketSession session;
}
