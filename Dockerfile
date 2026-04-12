# -------------------------
# 1. BUILD STAGE (Maven)
# -------------------------
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copy Spring Boot module (your structure)
COPY localserviceshub-services/pom.xml ./pom.xml
COPY localserviceshub-services/src ./src

# Run Maven build (YOUR REQUEST)
RUN mvn clean install -DskipTests

# -------------------------
# 2. RUNTIME STAGE (Java only)
# -------------------------
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy generated jar from build stage
COPY --from=build /app/target/*.jar app.jar

# Render dynamic port
ENV PORT 8080
EXPOSE 8080

# Start app
CMD ["java", "-jar", "app.jar"]