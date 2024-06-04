FROM arm64v8/openjdk:21-ea-21-jdk-slim

COPY target/employee-service.jar .

EXPOSE 8083

ENTRYPOINT ["java", "-jar", "employee-service.jar"]