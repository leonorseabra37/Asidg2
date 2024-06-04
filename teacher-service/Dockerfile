FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/teacher-service.jar .

EXPOSE 8085

ENTRYPOINT ["java", "-jar", "teacher-service.jar"]