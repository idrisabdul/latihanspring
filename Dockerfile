FROM openjdk:17-jdk-alpine
MAINTAINER idris
COPY target/latihan-0.0.1-SNAPSHOT.jar latihan-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/latihan-0.0.1-SNAPSHOT.jar"]