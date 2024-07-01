/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.codeadbackend.codead.entities;

import com.codeadbackend.codead.entities.templates.DTOs.BaseDTOTemplate;
import com.codeadbackend.codead.entities.templates.DTOs.EntityDTOTemplate;
import com.codeadbackend.codead.entities.templates.JustPackage;
import com.codeadbackend.codead.entities.templates.MainTemplate;
import com.codeadbackend.codead.entities.templates.Pom;
import com.codeadbackend.codead.entities.templates.Properties;
import com.codeadbackend.codead.entities.templates.controllers.BaseControllerImplementationTemplate;
import com.codeadbackend.codead.entities.templates.controllers.EntityControllerTemplate;
import com.codeadbackend.codead.entities.templates.entities.BaseEntityTemplate;
import com.codeadbackend.codead.entities.templates.entities.EntityTemplate;
import com.codeadbackend.codead.entities.templates.repositories.BaseRepositoryTemplate;
import com.codeadbackend.codead.entities.templates.repositories.EntityRepositoryTemplate;
import com.codeadbackend.codead.entities.templates.services.BaseServiceImplementationTemplate;
import com.codeadbackend.codead.entities.templates.services.EntityServiceTemplate;
import com.codeadbackend.codead.entities.templates.specification.SpecificationTemplate;
import com.codeadbackend.codead.utils.Utils;
import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import java.io.File;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DAVID
 */
@Component
@Scope("prototype")
public class Composer {

    public static final String PACKAGE_SOURCE = "src";
    public static final String PACKAGE_MAIN = "main";
    public static final String PACKAGE_JAVA = "java";
    public static final String PACKAGE_TEST = "test";
    public static final String PACKAGE_RESOURCES = "resources";
    public static final String PACKAGE_STATIC = "static";
    public static final String PACKAGE_TEMPLATES = "templates";

    public static final String PACKAGE_DTOS = "DTOs";
    public static final String PACKAGE_ENTITIES = "entities";
    public static final String PACKAGE_EXCEPTIONS = "exceptions";
    public static final String PACKAGE_RESPONSES = "responses";
    public static final String PACKAGE_CONTROLLERS = "controllers";
    public static final String PACKAGE_REPOSITORIES = "repositories";
    public static final String PACKAGE_SERVICES = "services";
    public static final String PACKAGE_UTILS = "utils";
    public static final String PACKAGE_SPECIFICATION = "specification";

    public static final String GENERATED_PROJECT_PATH = "src/main/resources/generator/projects";
    public static final String STATIC_FILES_PATH = "src/main/resources/generator/static";
    public static final String TEMPLATES_PATH = "templates/";

    public static final String JAVA_EXTENSION = ".java";
    public static final String XML_EXTENSION = ".xml";
    public static final String PROPERTIES_EXTENSION = ".properties";

    private Schema schema;
    private String pathRoot;
    private String pathMainClass;
    private String pathMainClassTest;
    private String pathApplicationProperties;
    private String pathStatic;
    private String pathTemplates;
    private String pathControllers;
    private String pathDTOs;
    private String pathEntities;
    private String pathRepositories;
    private String pathServices;
    private String pathUtils;

    @Autowired
    MyWebSocketSessionManager sessionManager;

    @Autowired
    freemarker.template.Configuration freemaker;

    public void start(Schema schema) {
        this.schema = schema;
        this.pathRoot = Utils.buildedFileName(
                Composer.GENERATED_PROJECT_PATH,
                this.schema.getId() + "_" + this.schema.getCreatedAt()
        );
        this.sendStartLog();
        this.createTreeFile();
        this.cloneStaticFiles();
        this.generateMainClasses();
        this.generateConfigurationFiles();
        this.generateDTOsLayer();
        this.generateControllerLayer();
        this.generateServiceLayer();
        this.generateRepositoryLayer();
        this.generateEntitiesLayer();
        this.generateSpecificationUtility();
        this.sendFinalLog();
    }

    private void sendStartLog() {
        Log log = new Log();
        log.setSchemaId(this.schema.getId());
        log.setSchemaCreatedAt(this.schema.getCreatedAt());
        log.setName(Log.STARTING);
        log.setMiliseconds(0);
        this.sessionManager.sendMessage(log.asJSON());
    }

    private void createTreeFile() {
        long startTime = System.currentTimeMillis();
        File projectFolder = new File(this.pathRoot);
        if (!projectFolder.exists()) {
            projectFolder.mkdirs();

            ArrayList<String> files = Utils.fileNames(this.schema.getMetadata().get_package());
            this.pathMainClass = Utils.buildedFileName(
                    this.pathRoot,
                    Composer.PACKAGE_SOURCE,
                    Composer.PACKAGE_MAIN,
                    Composer.PACKAGE_JAVA,
                    files.get(0),
                    files.get(1),
                    files.get(2)
            );
            this.pathMainClassTest = Utils.buildedFileName(
                    this.pathRoot,
                    Composer.PACKAGE_SOURCE,
                    Composer.PACKAGE_TEST,
                    Composer.PACKAGE_JAVA,
                    files.get(0),
                    files.get(1),
                    files.get(2)
            );
            this.pathApplicationProperties = Utils.buildedFileName(
                    this.pathRoot,
                    Composer.PACKAGE_SOURCE,
                    Composer.PACKAGE_MAIN,
                    Composer.PACKAGE_RESOURCES
            );
            this.pathStatic = Utils.buildedFileName(
                    this.pathRoot,
                    Composer.PACKAGE_SOURCE,
                    Composer.PACKAGE_MAIN,
                    Composer.PACKAGE_RESOURCES,
                    Composer.PACKAGE_STATIC
            );
            this.pathTemplates = Utils.buildedFileName(
                    this.pathRoot,
                    Composer.PACKAGE_SOURCE,
                    Composer.PACKAGE_MAIN,
                    Composer.PACKAGE_RESOURCES,
                    Composer.PACKAGE_TEMPLATES
            );
            this.pathControllers = Utils.buildedFileName(
                    this.pathMainClass,
                    Composer.PACKAGE_CONTROLLERS
            );
            this.pathDTOs = Utils.buildedFileName(
                    this.pathMainClass,
                    Composer.PACKAGE_DTOS
            );
            this.pathEntities = Utils.buildedFileName(
                    this.pathMainClass,
                    Composer.PACKAGE_ENTITIES
            );
            this.pathRepositories = Utils.buildedFileName(
                    this.pathMainClass,
                    Composer.PACKAGE_REPOSITORIES
            );
            this.pathServices = Utils.buildedFileName(
                    this.pathMainClass,
                    Composer.PACKAGE_SERVICES
            );
            this.pathUtils = Utils.buildedFileName(
                    this.pathMainClass,
                    Composer.PACKAGE_UTILS
            );

            ArrayList<String> pathes = new ArrayList();
            pathes.add(this.pathMainClass);
            pathes.add(this.pathMainClassTest);
            pathes.add(this.pathApplicationProperties);
            pathes.add(this.pathStatic);
            pathes.add(this.pathTemplates);
            pathes.add(this.pathControllers);
            pathes.add(this.pathDTOs);
            pathes.add(this.pathEntities);
            pathes.add(this.pathRepositories);
            pathes.add(this.pathServices);
            pathes.add(this.pathUtils);

            for (String path : pathes) {
                File directory = new File(path);
                directory.mkdirs();
            }
            long endTime = System.currentTimeMillis();
            Log log = new Log();
            log.setSchemaId(this.schema.getId());
            log.setSchemaCreatedAt(this.schema.getCreatedAt());
            log.setName(Log.GENERATING_TREE_FILE);
            log.setMiliseconds(endTime - startTime);
            this.sessionManager.sendMessage(log.asJSON());
        }
    }

    private void cloneStaticFiles() {
        long startTime = System.currentTimeMillis();
        Utils.copy(Composer.STATIC_FILES_PATH, this.pathRoot);
        long endTime = System.currentTimeMillis();
        Log log = new Log();
        log.setSchemaId(this.schema.getId());
        log.setSchemaCreatedAt(this.schema.getCreatedAt());
        log.setName(Log.CLONATION_STATIC_FILES);
        log.setMiliseconds(endTime - startTime);
        this.sessionManager.sendMessage(log.asJSON());
    }

    private void generateMainClasses() {
        try {
            long startTime = System.currentTimeMillis();
            Template mainTemplate = freemaker.getTemplate(Composer.TEMPLATES_PATH + "Main.template");
            String _package = this.schema.getMetadata().get_package();
            String mainClass = Utils.capitalizeFirstLetter(this.schema.getMetadata().getName()) + "Application";
            MainTemplate mainTemplateClass = new MainTemplate();
            mainTemplateClass.set_package(_package);
            mainTemplateClass.set_className(mainClass);
            String fileNameMainClass = this.pathMainClass + "/" + mainClass + Composer.JAVA_EXTENSION;
            Writer mainClassWriter = new FileWriter(fileNameMainClass);
            mainTemplate.process(mainTemplateClass, mainClassWriter);

            Template mainTestTemplate = freemaker.getTemplate(Composer.TEMPLATES_PATH + "MainTests.template");
            String mainTestClass = Utils.capitalizeFirstLetter(this.schema.getMetadata().getName()) + "ApplicationTests";
            MainTemplate mainTestTemplateClass = new MainTemplate();
            mainTestTemplateClass.set_package(_package);
            mainTestTemplateClass.set_className(mainTestClass);
            String fileNameMainTestClass = this.pathMainClassTest + "/" + mainTestClass + Composer.JAVA_EXTENSION;
            Writer mainTestClassWriter = new FileWriter(fileNameMainTestClass);
            mainTestTemplate.process(mainTestTemplateClass, mainTestClassWriter);

            long endTime = System.currentTimeMillis();
            Log log = new Log();
            log.setSchemaId(this.schema.getId());
            log.setSchemaCreatedAt(this.schema.getCreatedAt());
            log.setName(Log.GENERATING_MAIN);
            log.setMiliseconds(endTime - startTime);
            this.sessionManager.sendMessage(log.asJSON());
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateConfigurationFiles() {
        try {
            long startTime = System.currentTimeMillis();
            Pom pom = new Pom();
            pom.setGroup(this.schema.getMetadata().getGroup());
            pom.setArtifact(this.schema.getMetadata().getArtifact());
            pom.setName(this.schema.getMetadata().getName());
            pom.setDescription(this.schema.getMetadata().getDescription());
            String pomFileName = this.pathRoot + "/pom" + Composer.XML_EXTENSION;
            Writer pomWriter = new FileWriter(pomFileName);
            Template pomTemplate = freemaker.getTemplate(Composer.TEMPLATES_PATH + "Pom.template");
            pomTemplate.process(pom, pomWriter);

            Properties properties = new Properties();
            properties.setAppName(this.schema.getMetadata().getName());
            properties.setDbUrl(this.schema.getProfile().getUrl());
            properties.setDbUser(this.schema.getProfile().getUser());
            properties.setDbPassword(this.schema.getProfile().getPassword());
            properties.setDdl(this.schema.getProfile().getDdl());
            properties.setServerPort(this.schema.getProfile().getPort());
            String applicationFileName = this.pathApplicationProperties + "/application" + Composer.PROPERTIES_EXTENSION;
            Writer applicationFileWriter = new FileWriter(applicationFileName);
            Template applicationTemplate = freemaker.getTemplate(Composer.TEMPLATES_PATH + "Properties.template");
            applicationTemplate.process(properties, applicationFileWriter);

            long endTime = System.currentTimeMillis();
            Log log = new Log();
            log.setSchemaId(this.schema.getId());
            log.setSchemaCreatedAt(this.schema.getCreatedAt());
            log.setName(Log.GENERATING_CONFIGURATION_FILES);
            log.setMiliseconds(endTime - startTime);
            this.sessionManager.sendMessage(log.asJSON());
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateDTOsLayer() {
        this.generateDTOsForResponses();
        this.generateDTOsForExceptions();
        this.generateDTOsForBaseEntities();
        this.generateDTOsForEntities();
    }

    private void generateDTOsForResponses() {
        try {
            String DTOsPackageFile = this.pathDTOs + "/" + Composer.PACKAGE_RESPONSES;
            File folder = new File(DTOsPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String[] DTOsForResponses = {"PageDTO", "PageableDTO", "ResponseDTO", "SortDTO"};
            for (String DTOname : DTOsForResponses) {
                long startTime = System.currentTimeMillis();
                JustPackage justPackage = new JustPackage();
                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_DTOS,
                        Composer.PACKAGE_RESPONSES
                );
                justPackage.set_package(_package);
                String fileName = DTOsPackageFile + "/" + DTOname + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_DTOS + "/" + DTOname + ".template");
                template.process(justPackage, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_DTOS);
                log.setMessage(DTOname);
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateDTOsForExceptions() {
        try {
            String DTOsPackageFile = this.pathDTOs + "/" + Composer.PACKAGE_EXCEPTIONS;
            File folder = new File(DTOsPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String[] DTOsForExceptions = {"ExceptionDTO", "SubExceptionDTO"};
            for (String DTOname : DTOsForExceptions) {
                long startTime = System.currentTimeMillis();
                JustPackage justPackage = new JustPackage();
                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_DTOS,
                        Composer.PACKAGE_EXCEPTIONS
                );
                justPackage.set_package(_package);
                String fileName = DTOsPackageFile + "/" + DTOname + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_DTOS + "/" + DTOname + ".template");
                template.process(justPackage, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_DTOS);
                log.setMessage(DTOname);
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateDTOsForBaseEntities() {
        try {
            String DTOsPackageFile = this.pathDTOs + "/" + Composer.PACKAGE_ENTITIES;
            File folder = new File(DTOsPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String[] DTOSForBaseDTO = {"BaseActivatedDTO", "BaseCreateDTO", "BaseDTO", "BaseShowDTO", "BaseUpdateDTO"};
            for (String DTOname : DTOSForBaseDTO) {
                long startTime = System.currentTimeMillis();
                BaseDTOTemplate baseDTO = new BaseDTOTemplate();
                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_DTOS,
                        Composer.PACKAGE_ENTITIES
                );
                baseDTO.set_package(_package);
                String _packageEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_ENTITIES
                );
                baseDTO.set_packageEntities(_packageEntities);
                String fileName = DTOsPackageFile + "/" + DTOname + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_DTOS + "/" + DTOname + ".template");
                template.process(baseDTO, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_DTOS);
                log.setMessage(DTOname);
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateDTOsForEntities() {
        try {
            String DTOsPackageFile = this.pathDTOs + "/" + Composer.PACKAGE_ENTITIES;
            File folder = new File(DTOsPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            for (Entity entity : this.schema.getEntities()) {
                String entityName = entity.getName();
                String entityNameAsVariable = Utils.uncapitalizeFirstLetter(entityName);
                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_DTOS,
                        Composer.PACKAGE_ENTITIES,
                        entityNameAsVariable
                );
                String _packageEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_ENTITIES
                );
                String _packageDTOsEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_DTOS,
                        Composer.PACKAGE_ENTITIES
                );

                EntityDTOTemplate entityDTOTemplate = new EntityDTOTemplate();
                entityDTOTemplate.set_package(_package);
                entityDTOTemplate.set_packageEntities(_packageEntities);
                entityDTOTemplate.set_packageDTOsEntities(_packageDTOsEntities);
                entityDTOTemplate.setEntity(entity);

                String entityFile = Utils.buildedFileName(
                        this.pathDTOs,
                        Composer.PACKAGE_ENTITIES,
                        entityNameAsVariable
                );
                File folderEntity = new File(entityFile);
                if (!folderEntity.exists()) {
                    folderEntity.mkdirs();
                }

                String[] DTOSForEntityDTO = {"EntityActivatedDTO", "EntityCreateDTO", "EntityShowDTO", "EntityUpdateDTO"};
                for (String DTOname : DTOSForEntityDTO) {
                    long startTime = System.currentTimeMillis();

                    String fileNameMain = DTOname.replace("Entity", entityName) + Composer.JAVA_EXTENSION;
                    String fileName = Utils.buildedFileName(
                            entityFile,
                            fileNameMain
                    );
                    Writer fileWriter = new FileWriter(fileName);
                    Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_DTOS + "/" + DTOname + ".template");
                    template.process(entityDTOTemplate, fileWriter);

                    long endTime = System.currentTimeMillis();
                    Log log = new Log();
                    log.setSchemaId(this.schema.getId());
                    log.setSchemaCreatedAt(this.schema.getCreatedAt());
                    log.setName(Log.GENERATING_DTOS);
                    log.setMessage(DTOname.replace("Entity", entityName));
                    log.setMiliseconds(endTime - startTime);
                    this.sessionManager.sendMessage(log.asJSON());
                }
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateControllerLayer() {
        this.generateControllersForBaseController();
        this.generateControllersForEntityController();
    }

    private void generateControllersForBaseController() {
        try {
            String controllersPackageFile = this.pathControllers;
            File folder = new File(controllersPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String controllerForBaseController = "BaseControllerImplementation";
            long startTime = System.currentTimeMillis();
            BaseControllerImplementationTemplate baseController = new BaseControllerImplementationTemplate();

            String _package = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_CONTROLLERS
            );
            baseController.set_package(_package);
            String _packageDTOsEntities = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_DTOS,
                    Composer.PACKAGE_ENTITIES
            );
            baseController.set_packageDTOsEntities(_packageDTOsEntities);
            String _packageDTOsResponses = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_DTOS,
                    Composer.PACKAGE_RESPONSES
            );
            baseController.set_packageDTOsResponses(_packageDTOsResponses);
            String _packageEntities = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_ENTITIES
            );
            baseController.set_packageEntities(_packageEntities);
            String _packageServices = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_SERVICES
            );
            baseController.set_packageServices(_packageServices);
            String _packageUtilsSpecification = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_UTILS,
                    Composer.PACKAGE_SPECIFICATION
            );
            baseController.set_packageUtilsSpecification(_packageUtilsSpecification);

            String fileName = controllersPackageFile + "/" + controllerForBaseController + Composer.JAVA_EXTENSION;
            Writer fileWriter = new FileWriter(fileName);
            Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_CONTROLLERS + "/" + controllerForBaseController + ".template");
            template.process(baseController, fileWriter);

            long endTime = System.currentTimeMillis();
            Log log = new Log();
            log.setSchemaId(this.schema.getId());
            log.setSchemaCreatedAt(this.schema.getCreatedAt());
            log.setName(Log.GENERATING_CONTROLLERS);
            log.setMessage(controllerForBaseController);
            log.setMiliseconds(endTime - startTime);
            this.sessionManager.sendMessage(log.asJSON());
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateControllersForEntityController() {
        try {
            String controllersPackageFile = this.pathControllers;
            File folder = new File(controllersPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String controllerForEntityController = "EntityController";
            for (Entity entity : this.schema.getEntities()) {
                long startTime = System.currentTimeMillis();
                EntityControllerTemplate entityController = new EntityControllerTemplate(entity);

                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_CONTROLLERS
                );
                entityController.set_package(_package);
                String _packageDTOsEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_DTOS,
                        Composer.PACKAGE_ENTITIES
                );
                entityController.set_packageDTOsEntities(_packageDTOsEntities);
                String _packageEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_ENTITIES
                );
                entityController.set_packageEntities(_packageEntities);

                String fileName = controllersPackageFile + "/" + controllerForEntityController.replace("Entity", entity.getName()) + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_CONTROLLERS + "/" + controllerForEntityController + ".template");
                template.process(entityController, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_CONTROLLERS);
                log.setMessage(controllerForEntityController.replace("Entity", entity.getName()));
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateServiceLayer() {
        this.generateServiceForBaseService();
        this.generateServiceForEntityService();
    }

    private void generateServiceForBaseService() {
        try {
            String servicesPackageFile = this.pathServices;
            File folder = new File(servicesPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String serviceForBaseService = "BaseServiceImplementation";
            long startTime = System.currentTimeMillis();
            BaseServiceImplementationTemplate baseService = new BaseServiceImplementationTemplate();

            String _package = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_SERVICES
            );
            baseService.set_package(_package);
            String _packageEntities = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_ENTITIES
            );
            baseService.set_packageEntities(_packageEntities);
            String _packageRepositories = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_REPOSITORIES
            );
            baseService.set_packageRepositories(_packageRepositories);

            String fileName = servicesPackageFile + "/" + serviceForBaseService + Composer.JAVA_EXTENSION;
            Writer fileWriter = new FileWriter(fileName);
            Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_SERVICES + "/" + serviceForBaseService + ".template");
            template.process(baseService, fileWriter);

            long endTime = System.currentTimeMillis();
            Log log = new Log();
            log.setSchemaId(this.schema.getId());
            log.setSchemaCreatedAt(this.schema.getCreatedAt());
            log.setName(Log.GENERATING_SERVICES);
            log.setMessage(serviceForBaseService);
            log.setMiliseconds(endTime - startTime);
            this.sessionManager.sendMessage(log.asJSON());
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateServiceForEntityService() {
        try {
            String servicesPackageFile = this.pathServices;
            File folder = new File(servicesPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String serviceForEntityService = "EntityService";
            for (Entity entity : this.schema.getEntities()) {
                long startTime = System.currentTimeMillis();
                EntityServiceTemplate entityService = new EntityServiceTemplate(entity);

                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_SERVICES
                );
                entityService.set_package(_package);
                String _packageEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_ENTITIES
                );
                entityService.set_packageEntities(_packageEntities);
                String _packageRepositories = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_REPOSITORIES
                );
                entityService.set_packageRepositories(_packageRepositories);

                String fileName = servicesPackageFile + "/" + serviceForEntityService.replace("Entity", entity.getName()) + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_SERVICES + "/" + serviceForEntityService + ".template");
                template.process(entityService, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_SERVICES);
                log.setMessage(serviceForEntityService.replace("Entity", entity.getName()));
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateRepositoryLayer() {
        this.generateRepositoryForBaseRepository();
        this.generateRepositoryForEntityRepository();
    }

    private void generateRepositoryForBaseRepository() {
        try {
            String repositoriesPackageFile = this.pathRepositories;
            File folder = new File(repositoriesPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String repositoryForBaseRepository = "BaseRepository";
            long startTime = System.currentTimeMillis();
            BaseRepositoryTemplate baseRepository = new BaseRepositoryTemplate();

            String _package = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_REPOSITORIES
            );
            baseRepository.set_package(_package);
            String _packageEntities = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_ENTITIES
            );
            baseRepository.set_packageEntities(_packageEntities);

            String fileName = repositoriesPackageFile + "/" + repositoryForBaseRepository + Composer.JAVA_EXTENSION;
            Writer fileWriter = new FileWriter(fileName);
            Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_REPOSITORIES + "/" + repositoryForBaseRepository + ".template");
            template.process(baseRepository, fileWriter);

            long endTime = System.currentTimeMillis();
            Log log = new Log();
            log.setSchemaId(this.schema.getId());
            log.setSchemaCreatedAt(this.schema.getCreatedAt());
            log.setName(Log.GENERATING_REPOSITORIES);
            log.setMessage(repositoryForBaseRepository);
            log.setMiliseconds(endTime - startTime);
            this.sessionManager.sendMessage(log.asJSON());
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateRepositoryForEntityRepository() {
        try {
            String repositoriesPackageFile = this.pathRepositories;
            File folder = new File(repositoriesPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String repositoryForEntityRepository = "EntityRepository";
            for (Entity entity : this.schema.getEntities()) {
                long startTime = System.currentTimeMillis();
                EntityRepositoryTemplate entityService = new EntityRepositoryTemplate(entity);

                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_REPOSITORIES
                );
                entityService.set_package(_package);
                String _packageEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_ENTITIES
                );
                entityService.set_packageEntities(_packageEntities);

                String fileName = repositoriesPackageFile + "/" + repositoryForEntityRepository.replace("Entity", entity.getName()) + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_REPOSITORIES + "/" + repositoryForEntityRepository + ".template");
                template.process(entityService, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_REPOSITORIES);
                log.setMessage(repositoryForEntityRepository.replace("Entity", entity.getName()));
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateEntitiesLayer() {
        this.generateEntitiesForBaseEntity();
        this.generateEntitiesForEntity();
    }

    private void generateEntitiesForBaseEntity() {
        try {
            String entitiesPackageFile = this.pathEntities;
            File folder = new File(entitiesPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String entityForBaseEntity = "BaseEntity";
            long startTime = System.currentTimeMillis();
            BaseEntityTemplate baseEntity = new BaseEntityTemplate();

            String _package = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_ENTITIES
            );
            baseEntity.set_package(_package);
            String _packageDTOsEntities = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_DTOS,
                    Composer.PACKAGE_ENTITIES
            );
            baseEntity.set_packageDTOsEntities(_packageDTOsEntities);

            String fileName = entitiesPackageFile + "/" + entityForBaseEntity + Composer.JAVA_EXTENSION;
            Writer fileWriter = new FileWriter(fileName);
            Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_ENTITIES + "/" + entityForBaseEntity + ".template");
            template.process(baseEntity, fileWriter);

            long endTime = System.currentTimeMillis();
            Log log = new Log();
            log.setSchemaId(this.schema.getId());
            log.setSchemaCreatedAt(this.schema.getCreatedAt());
            log.setName(Log.GENERATING_ENTITIES);
            log.setMessage(entityForBaseEntity);
            log.setMiliseconds(endTime - startTime);
            this.sessionManager.sendMessage(log.asJSON());
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateEntitiesForEntity() {
        try {
            String entitiesPackageFile = this.pathEntities;
            File folder = new File(entitiesPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String entityForEntity = "Entity";
            for (Entity entity : this.schema.getEntities()) {
                long startTime = System.currentTimeMillis();
                EntityTemplate entityTemplate = new EntityTemplate(entity);

                String _package = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_ENTITIES
                );
                entityTemplate.set_package(_package);
                String _packageDTOsEntities = Utils.buildedPackage(
                        this.schema.getMetadata().get_package(),
                        Composer.PACKAGE_DTOS,
                        Composer.PACKAGE_ENTITIES
                );
                entityTemplate.set_packageDTOsEntities(_packageDTOsEntities);

                String fileName = entitiesPackageFile + "/" + entityForEntity.replace("Entity", entity.getName()) + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(Composer.TEMPLATES_PATH + Composer.PACKAGE_ENTITIES + "/" + entityForEntity + ".template");
                template.process(entityTemplate, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_ENTITIES);
                log.setMessage(entityForEntity.replace("Entity", entity.getName()));
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void generateSpecificationUtility() {
        try {
            String entitiesPackageFile = this.pathUtils;
            File folder = new File(entitiesPackageFile);
            if (!folder.exists()) {
                folder.mkdirs();
            }

            String specificationPackageFile = Utils.buildedFileName(
                    this.pathMainClass,
                    Composer.PACKAGE_UTILS,
                    Composer.PACKAGE_SPECIFICATION
            );
            File folderSpecification = new File(specificationPackageFile);
            if (!folderSpecification.exists()) {
                folderSpecification.mkdirs();
            }

            SpecificationTemplate specificationTemplate = new SpecificationTemplate();
            String _package = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_UTILS,
                    Composer.PACKAGE_SPECIFICATION
            );
            specificationTemplate.set_package(_package);
            String _packageEntities = Utils.buildedPackage(
                    this.schema.getMetadata().get_package(),
                    Composer.PACKAGE_ENTITIES
            );
            specificationTemplate.set_packageEntity(_packageEntities);

            String[] specifications = {"Connector", "ConnectorList", "Group", "Predicate", "PredicateList", "Specification"};
            for (String specification : specifications) {
                long startTime = System.currentTimeMillis();

                String fileName = specificationPackageFile + "/" + specification + Composer.JAVA_EXTENSION;
                Writer fileWriter = new FileWriter(fileName);
                Template template = freemaker.getTemplate(
                        Composer.TEMPLATES_PATH
                        + Composer.PACKAGE_SPECIFICATION + "/" + specification + ".template");
                template.process(specificationTemplate, fileWriter);

                long endTime = System.currentTimeMillis();
                Log log = new Log();
                log.setSchemaId(this.schema.getId());
                log.setSchemaCreatedAt(this.schema.getCreatedAt());
                log.setName(Log.GENERATING_SPECIFICATION);
                log.setMessage(specification);
                log.setMiliseconds(endTime - startTime);
                this.sessionManager.sendMessage(log.asJSON());
            }
        } catch (MalformedTemplateNameException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TemplateException ex) {
            Logger.getLogger(Composer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void sendFinalLog() {
        Log log = new Log();
        log.setSchemaId(this.schema.getId());
        log.setSchemaCreatedAt(this.schema.getCreatedAt());
        log.setName(Log.ENDING);
        log.setMiliseconds(0);
        this.sessionManager.sendMessage(log.asJSON());
    }
}
