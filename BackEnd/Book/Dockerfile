FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD target/Book-0.0.1-SNAPSHOT.jar book.jar
ENTRYPOINT ["java","-jar","/book.jar"]