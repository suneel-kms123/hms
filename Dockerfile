FROM openjdk:17-jdk-alpine
MAINTAINER suneel-kms123
WORKDIR /app
# Add the service's jar file
COPY build/libs/*SNAPSHOT.jar /app.jar

EXPOSE 8080
# Run the service
CMD ["java", "-jar", "app.jar"]