FROM openjdk:8-jdk-alpine
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE
ADD ${JAR_FILE} oauth-server.jar
ENTRYPOINT ["java","-jar","/oauth-server.jar"]