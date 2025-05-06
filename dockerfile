# Imagen base con Java 21
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el JAR de la aplicación al contenedor
COPY target/prueba-0.0.1-SNAPSHOT.jar app.jar

# Exponemos el puerto que usa la app (ajústalo si usas otro)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
