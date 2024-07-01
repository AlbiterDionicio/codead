/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.handlers;

import com.codeadbackend.codead.entities.MyWebSocketSession;
import com.codeadbackend.codead.entities.MyWebSocketSessionManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

/**
 *
 * @author DAVID
 */
@Slf4j
public class GeneratorHandler implements WebSocketHandler {
    @Autowired
    MyWebSocketSessionManager sessionManager;
    
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String frontendIdKey = MyWebSocketSession.FRONTEND_ID;
        String frontendIdValue = (String)session.getAttributes().get(frontendIdKey);
        MyWebSocketSession myWebSocketSession = new MyWebSocketSession().builder()
                .frontendId(frontendIdValue)
                .session(session)
                .build();
        this.sessionManager.add(myWebSocketSession);
        System.out.println(this.sessionManager);
        log.info("Connection established on session: {}", session.getId());
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        System.out.println(message);
        System.out.println(this.sessionManager);
        session.sendMessage(message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.info("Exception occured: {} on session: {}", exception.getMessage(), session.getId());
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        this.sessionManager.remove(session);
        log.info("Connection closed on session: {} with status: {}", session.getId(), closeStatus.getCode());
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
