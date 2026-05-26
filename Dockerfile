FROM maven:3.9.6-eclipse-temurin-21 AS buildstage
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B
COPY src ./src
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=buildstage /app/target/autenticacion-service-0.0.1-SNAPSHOT.jar /app/app.jar

# Exponer el puerto de tu microservicio
EXPOSE 8081

CMD ["java", "-jar", "/app/app.jar"]