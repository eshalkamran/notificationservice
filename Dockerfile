# Use the official Maven image with OpenJDK 17 as a base image
FROM maven:3.8.4-openjdk-17-slim as build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml file into the container at /app
COPY pom.xml .

# Download project dependencies
RUN mvn dependency:go-offline

# Copy the rest of the application into the container at /app
COPY src ./src

# Package the application into a JAR file
RUN mvn package -DskipTests

# Use the official OpenJDK 17 image as a base image
FROM openjdk:17-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build stage into the container at /app
COPY --from=build /app/target/notificationservice-0.0.1-SNAPSHOT.jar ./notificationservice.jar

# Expose port 8083
EXPOSE 8083

# Command to run the application
CMD ["java", "-jar", "./notificationservice.jar"]
