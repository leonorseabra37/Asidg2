FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/gateway-0.0.1-SNAPSHOT.jar .

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "gateway-0.0.1-SNAPSHOT.jar"]