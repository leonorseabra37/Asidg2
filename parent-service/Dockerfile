FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/parent-service.jar .

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "parent-service.jar"]