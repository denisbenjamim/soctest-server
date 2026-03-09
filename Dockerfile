FROM maven:3.9-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# -------- RUNTIME STAGE --------
FROM tomcat:10.1-jre21-temurin

RUN rm -rf /usr/local/tomcat/webapps/*

COPY --from=builder /build/target/*.war /usr/local/tomcat/webapps/soctest.war

EXPOSE 8080

# Comando para executar o projeto quando o contêiner for iniciado
CMD ["catalina.sh","run"]