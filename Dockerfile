# ==========================================
# Stage 1: Build the Spring Boot App
# ==========================================
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copy the Gradle wrapper files first (good for Docker caching)
COPY gradlew .
COPY gradle gradle

# Copy the build configuration files
COPY build.gradle settings.gradle ./

# Grant execution rights to the wrapper (Required for Linux cloud servers)
RUN chmod +x gradlew

# Copy the actual source code
COPY src src

# Build the application, skipping tests to speed up deployment
RUN ./gradlew build -x test

# ==========================================
# Stage 2: Run the App
# ==========================================
FROM eclipse-temurin:21-jre-alpine
WORKDIR /app

# Create a non-root system group and user (no login shell, no home dir)
# Running as root inside the container is a security risk — if the app
# is ever compromised (RCE, etc.), root access widens the blast radius
RUN addgroup -S spring && adduser -S spring -G spring

# Copy the generated JAR file from the Gradle build folder
# Note: Gradle puts compiled jars in /build/libs/ instead of /target/
COPY --from=build /app/build/libs/*-SNAPSHOT.jar app.jar

# Switch to non-root user before running the app
USER spring

# Expose the standard Spring Boot port
EXPOSE 8080

# Run the application
# Cap JVM heap to 75% of the container's allocated RAM instead of
# guessing based on host memory — prevents OOM-kills on memory-limited
# hosts like Render's free/small tiers
ENTRYPOINT ["java", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]
