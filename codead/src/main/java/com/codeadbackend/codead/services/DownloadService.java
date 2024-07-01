/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.services;

import com.codeadbackend.codead.daos.ResponseDao;
import com.codeadbackend.codead.entities.Composer;
import com.codeadbackend.codead.services.errors.DownloadInputError;
import com.codeadbackend.codead.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import org.springframework.stereotype.Service;

/**
 *
 * @author DAVID
 */
@Service
public class DownloadService {
    public static final String ZIP_EXTENSION = "zip";
    public static final String DEFAULT_ZIP_NAME = "spring_boot_v3_backend" + "." + DownloadService.ZIP_EXTENSION;
    public static final Pattern ZIP_PATTERN = Pattern.compile("^.*\\." + DownloadService.ZIP_EXTENSION + "$");

    public ResponseDao process(String schemaId, String createdAt) {

        ResponseDao responseDao = new ResponseDao();
        String backendName = "";
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
                ZipOutputStream zos = new ZipOutputStream(baos)) {
            DownloadService.isValidInputs(schemaId, createdAt);
            
            backendName = schemaId + "_" + createdAt;
            String fileName = Utils.buildedFileName(
                    Composer.GENERATED_PROJECT_PATH,
                    backendName
            );
            File folderToZip = new File(fileName);
            if(!folderToZip.exists()){
                throw new DownloadInputError("Backend no encontrado, genere un backend primero para poder empaquetarlo y luego descargarlo");
            }

            DownloadService.zipFolder(folderToZip, folderToZip.getName(), zos);

            zos.close();

            responseDao.setZip(baos.toByteArray());
        } catch (DownloadInputError e) {
            System.out.println("Error User: " + e.getMessage());
            responseDao.setError(ResponseDao.ERROR_USER_CODE);
        } catch (IOException e) {
            System.err.println("Error when packaging: " + e.getMessage());
            responseDao.setError(ResponseDao.ERROR_SYSTEM_CODE);
        } finally {
            System.out.println("Succes zip packaging. Backend name: " + backendName);
            responseDao.setSuccess();
            return responseDao;
        }
    }

    private static void isValidInputs(String schemaId, String createdAt) throws DownloadInputError {
        if(schemaId == null){
            throw new DownloadInputError("schemaId debe no ser nulo");
        }
        if(schemaId.trim().equals("")){
            throw new DownloadInputError("schemaId debe no ser vacío");
        }
        String regexJustNumbers = "^\\d+$";
        Pattern pattern = Pattern.compile(regexJustNumbers);

        Matcher matcherSchemaId = pattern.matcher(schemaId);
        if(!matcherSchemaId.matches()){
            throw new DownloadInputError("schemaId debe contener solo números");
        }
        
        if(createdAt == null){
            throw new DownloadInputError("createdAt debe no ser nulo");
        }
        if(createdAt.trim().equals("")){
            throw new DownloadInputError("createdAt debe no ser vacío");
        }
        Matcher matcherCreatedAt = pattern.matcher(schemaId);
        if(!matcherCreatedAt.matches()){
            throw new DownloadInputError("createdAt debe contener solo números");
        }
    }

    private static void zipFolder(File folder, String parentFolder, ZipOutputStream zos) throws IOException {
        for (File file : folder.listFiles()) {
            if (file.isDirectory()) {
                zipFolder(file, parentFolder + "/" + file.getName(), zos);
            } else {
                String entryName = parentFolder + "/" + file.getName();
                ZipEntry zipEntry = new ZipEntry(entryName);
                zos.putNextEntry(zipEntry);

                try (FileInputStream fis = new FileInputStream(file)) {
                    byte[] buffer = new byte[1024];
                    int length;

                    while ((length = fis.read(buffer)) > 0) {
                        zos.write(buffer, 0, length);
                    }
                }

                zos.closeEntry();
            }
        }
    }
    
    public static String addExtension(String zipName) {
        Matcher matcher = DownloadService.ZIP_PATTERN.matcher(zipName);
        if(!matcher.matches()){
            return zipName + "." + DownloadService.ZIP_EXTENSION;
        }
        return zipName;
    }
}
