FROM maven:3.6.3-jdk-11-openj9 as builder
WORKDIR /app
COPY . .
#COPY configuration.properties .
#RUN mvn clean
#COPY src ./src
#RUN mvn package -Dmaven verify
#FROM adoptopenjdk/openjdk11
#COPY --from=builder /app/target/mobiquity*.jar /mobiquity.jar
ENTRYPOINT ["mvn","test"]
  ## Run the web service on container startup.
#CMD ["java","-Dcom.sun.net.ssl.checkRevocation=false","-Dserver.port=8080","-jar","mobiquity.jar"]
#ARG JAR_FILE=target/*.jar