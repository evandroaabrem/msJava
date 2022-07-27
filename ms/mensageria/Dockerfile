FROM openjdk:11-jdk-slim
ARG JAR_FILE=ms/mensageria/target/*.jar
COPY ${JAR_FILE} /app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]