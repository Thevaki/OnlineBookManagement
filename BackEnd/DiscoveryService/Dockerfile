FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/DiscoveryService-0.0.1-SNAPSHOT.jar discoveryservice.jar
ENTRYPOINT ["java","-jar","/discoveryservice.jar"]