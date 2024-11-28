# Build Stage
FROM maven:3.9.4-eclipse-temurin-21 AS build
WORKDIR /build
COPY pom.xml .
RUN mvn dependency:go-offline
COPY src ./src
RUN mvn clean package -DskipTests

# Runtime Stage
FROM amazoncorretto:21

# Define build-time arguments
ARG PROFILE=dev
ARG APP_VERSION=1.0.0

# Set runtime environment variables
ENV DB_URL=
ENV DB_USERNAME=
ENV DB_PASSWORD=
ENV JWT_SECRET=
ENV ACTIVE_PROFILE=${PROFILE}
ENV JAR_VERSION=${APP_VERSION}

WORKDIR /app

# Copy the built JAR file from the build stage
COPY --from=build /build/target/personal-service-*.jar /app/

# Expose the application port
EXPOSE 8088

# Command to run the application
CMD ["sh", "-c", "java -jar -Dspring.profiles.active=${ACTIVE_PROFILE} /app/personal-service-${JAR_VERSION}.jar"]
