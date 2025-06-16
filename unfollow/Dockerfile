# Etapa 1: build com Maven
FROM maven:3.9.6-eclipse-temurin-21 AS build

WORKDIR /app
COPY . .
RUN mvn clean install -DskipTests=true

# Etapa 2: runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY --from=build /app/target/unfollow-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
