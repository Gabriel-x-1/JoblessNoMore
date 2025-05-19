FROM maven:3.8.4-openjdk-17 as builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:17-slim
WORKDIR /app
COPY --from=builder /app/target/*.jar app.jar
EXPOSE 8080

# Development mode with remote debugging enabled
ENV JAVA_OPTS="-Dspring.devtools.restart.enabled=true -Dspring.devtools.restart.poll-interval=2s -Dspring.devtools.restart.quiet-period=1s"
ENTRYPOINT java ${JAVA_OPTS} -jar app.jar
