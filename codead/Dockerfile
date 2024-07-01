
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

FROM openjdk:17-jdk-slim
#crear una ruta de trabajo
WORKDIR /codead
# Copia el archivo JAR de tu proyecto al contenedor
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} codead.jar
#COPY .mvn/ .mvn
#COPY mvnw pom.xml ./
#COPY mvnw.cmd ./
#COPY .gitignore ./
#COPY pom.xml ./
# Crea el directorio para los archivos estáticos (si es necesario)
RUN mkdir -p src/main/resources/generator/static
# Copia los archivos estáticos al contenedor
COPY src/main/resources/generator/static src/main/resources/generator/static
# Crea el directorio para los archivos estáticos (si es necesario)
RUN mkdir -p src/main/resources/generator/templates
# Copia los archivos estáticos al contenedor
COPY src/main/resources/generator/templates src/main/resources/generator/templates
#RUN ./mvnw dependency:go-offline
#COPY src ./src
# Crea un directorio para los archivos de salida
#RUN mkdir /app/output && chmod 777 /app/output
# Expone el puerto 8080 (si es necesario)
EXPOSE 8080
#CMD ["./mvnw", "spring-boot:run"]
# Define el comando de entrada para ejecutar la aplicación Java
ENTRYPOINT ["java", "-jar", "codead.jar"]
#CMD ["/bin/sh"]