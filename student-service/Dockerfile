FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/student-service.jar .

EXPOSE 8084

ENTRYPOINT ["java", "-jar", "student-service.jar"]