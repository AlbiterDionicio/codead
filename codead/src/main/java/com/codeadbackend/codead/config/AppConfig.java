/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.config;

import freemarker.cache.ClassTemplateLoader;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.IOException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author DAVID
 */
@Configuration
public class AppConfig {
    @Bean
    public freemarker.template.Configuration freemaker() throws IOException{
        freemarker.template.Configuration freemaker = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_31);
        //freemaker.setDirectoryForTemplateLoading(new File("src/main/resources/generator"));
        //Usamos ClassTemplateLoader para cargar plantillas desde el classpath
        freemaker.setTemplateLoader(new ClassTemplateLoader(getClass(), "/generator"));
        freemaker.setDefaultEncoding("UTF-8");
        freemaker.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        freemaker.setLogTemplateExceptions(false);
        freemaker.setWrapUncheckedExceptions(true);
        freemaker.setFallbackOnNullLoopVariable(false);
        return freemaker;
    }
}