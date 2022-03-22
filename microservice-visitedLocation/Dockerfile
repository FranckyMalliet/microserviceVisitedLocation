FROM openjdk:16.0.1
VOLUME /tmp
ARG JAR_FILE=target/microserviceVisitedLocation.jar
COPY ${JAR_FILE} microserviceVisitedLocation.jar
ENTRYPOINT ["java","-jar","/microserviceVisitedLocation.jar"]