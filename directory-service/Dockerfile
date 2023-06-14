FROM openjdk:17 as build
LABEL maintainer="bharathy@igreendata.com.au"
ADD build/libs/directory-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/app.jar"]