FROM maven:3.8.4-openjdk-17-slim

WORKDIR /app

COPY target/StudentsRetake-0.0.1-SNAPSHOT.jar /app/

CMD ["java", "-jar", "StudentsRetake-0.0.1-SNAPSHOT.jar"]