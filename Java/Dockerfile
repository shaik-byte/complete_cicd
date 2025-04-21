# Step 1: Build stage using Maven
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Create app directory in container
WORKDIR /app

# Copy pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy source files
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Step 2: Runtime stage using a smaller JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy JAR from builder stage
COPY --from=builder /app/target/codekamikaze-1.0.0.jar app.jar

# Expose the port Spring Boot runs on
EXPOSE 8080

# Run the Spring Boot app
ENTRYPOINT ["java", "-jar", "app.jar"]
