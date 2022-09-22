FROM openjdk:11-slim-bullseye
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} swagger-spring-1.0.0.jar
ENTRYPOINT ["java","-jar","/swagger-spring-1.0.0.jar"]