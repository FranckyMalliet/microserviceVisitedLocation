FROM openjdk:16.0.1
EXPOSE 80
VOLUME /tmp
ARG JAR_FILE=microservice-visitedLocation/build/libs/microserviceVisitedLocation.jar
COPY ${JAR_FILE} microserviceVisitedLocation.jar
ENTRYPOINT ["java","-jar","/microserviceVisitedLocation.jar"]