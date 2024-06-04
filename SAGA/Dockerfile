FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/saga-service.jar .

EXPOSE 9090

ENTRYPOINT ["java", "-jar", "saga-service.jar"]