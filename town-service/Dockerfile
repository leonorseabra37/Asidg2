FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/town-service.jar .

EXPOSE 8089

ENTRYPOINT ["java", "-jar", "town-service.jar"]