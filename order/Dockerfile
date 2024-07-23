# Utiliser une image de base Java
FROM openjdk:17-jdk-slim

# Définir le répertoire de travail
WORKDIR /app

# Copier le JAR construit dans le répertoire de travail
COPY target/Order-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8888

# Définir la commande pour exécuter l'application
ENTRYPOINT ["java", "-jar", "app.jar"]