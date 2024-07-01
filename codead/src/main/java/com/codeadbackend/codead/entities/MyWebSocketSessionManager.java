/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 *
 * @author DAVID
 */
@Getter
@Setter
public class MyWebSocketSessionManager {

    private final Map<String, MyWebSocketSession> sessions = new ConcurrentHashMap<>();

    public void add(MyWebSocketSession myWebSocketSession) {
        String key = myWebSocketSession.getSession().getId();
        this.sessions.put(key, myWebSocketSession);
    }

    public void remove(WebSocketSession session) {
        String key = session.getId();
        this.sessions.remove(key);
    }

    public void sendMessage(String message) {
        try {
            for (Map.Entry<String, MyWebSocketSession> entry : this.sessions.entrySet()) {
                WebSocketSession session = entry.getValue().getSession();
                TextMessage textMsg = new TextMessage(message);
                session.sendMessage(textMsg);
            }
        } catch (Exception e) {
            System.out.println("Exception in MyWebSocketSessionManager class");
            System.out.println(e);
        }
    }
}
