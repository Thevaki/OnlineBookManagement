FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/AuthService-0.0.1-SNAPSHOT.jar authservice.jar
ENTRYPOINT ["java","-jar","/authservice.jar"]