FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/discovery-service.jar .

EXPOSE 8761

ENTRYPOINT ["java", "-jar", "discovery-service.jar"]