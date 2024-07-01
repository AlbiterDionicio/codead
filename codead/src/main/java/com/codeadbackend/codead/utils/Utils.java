/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAVID
 */
public class Utils {
    public static String buildedPackage(String... packages){
        StringBuilder buildedPackage = new StringBuilder();
        for (int i = 0; i < packages.length; i++) {
            buildedPackage.append(packages[i]);
            if (i < packages.length - 1) {
                buildedPackage.append(".");
            }
        }
        return buildedPackage.toString();
    }
    
    public static ArrayList<String> fileNames(String packageProject){
        return new ArrayList<>(Arrays.asList(packageProject.split("\\.")));
    }
    
    public static String buildedFileName(String... fileNames){
        StringBuilder buildedFileName = new StringBuilder();
        for (int i = 0; i < fileNames.length; i++) {
            buildedFileName.append(fileNames[i]);
            if (i < fileNames.length - 1) {
                buildedFileName.append("/");
            }
        }
        return buildedFileName.toString();
    }
    
    public static synchronized void copy(String source, String target){
        Path sourcePath = Paths.get(source);
        Path targetPath = Paths.get(target);
        
        try {
            Files.walkFileTree(sourcePath, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Path targetFile = targetPath.resolve(sourcePath.relativize(file));
                    Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                    return FileVisitResult.CONTINUE;
                }
                
                @Override
                public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                    Path targetDir = targetPath.resolve(sourcePath.relativize(dir));
                    Files.createDirectories(targetDir);
                    return FileVisitResult.CONTINUE;
                }
            });
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static String capitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1);
    }
    
    public static String uncapitalizeFirstLetter(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toLowerCase() + text.substring(1);
    }
    
    public static String cleanString(String text, String clean){
        String newText = text;
        if(text == null){
            return newText;
        }
        if(text.contains(clean)){
            newText = text.replace(clean, "");
        }
        return newText;
    }
    
    public static String pluralize(String text){
        // Rule 1: words ends in 's', 'x', 'z', 'ch' or 'sh'
        if (text.matches(".*(s|x|z|ch|sh)$")) {
            return text + "es";
        }
        
        // Rule 2: words ends in 'y' and before a consonant
        if (text.matches(".*[^aeiou]y$")) {
            return text.replaceAll("y$", "ies");
        }
        
        // Rule 3: words ends in 'f' or 'fe'
        if (text.matches(".*[^aeiou]f$")) {
            return text.replaceAll("f$", "ves");
        }
        
        if (text.matches(".*[^aeiou]fe$")) {
            return text.replaceAll("fe$", "ves");
        }
        
        // Rule 4: words ends in 'o' before a consonant
        if (text.matches(".*[^aeiou]o$")) {
            return text + "es";
        }
        
        // Rule 5: in other cases, add 's'
        return text + "s";
    }
    
    public static String camelCaseToSnakeCase(String text){
        return text.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }
}
