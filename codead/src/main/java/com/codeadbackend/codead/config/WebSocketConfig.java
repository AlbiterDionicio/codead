/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.config;

import com.codeadbackend.codead.entities.MyWebSocketSessionManager;
import com.codeadbackend.codead.handlers.GeneratorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
/**
 *
 * @author DAVID
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry
                .addHandler(this.generatorHandler(), "/generator-logger")
                .setAllowedOrigins("*");
    }
    
    @Bean
    public GeneratorHandler generatorHandler() {
        return new GeneratorHandler();
    }
    
    @Bean
    public MyWebSocketSessionManager webSocketSessionManager(){
        return new MyWebSocketSessionManager();
    }
}
