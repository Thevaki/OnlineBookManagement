FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/User-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java","-jar","/user.jar"]