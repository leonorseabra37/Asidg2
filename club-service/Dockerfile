FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/club-service.jar .

EXPOSE 8082

ENTRYPOINT ["java", "-jar", "club-service.jar"]