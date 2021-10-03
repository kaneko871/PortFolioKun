FROM openjdk:8-jdk-alpine

COPY portfoliokun-0.0.1-SNAPSHOT.jar pfkweb.jar

ENTRYPOINT ["java","-Dspring.profiles.active=prod","-jar","/pfkweb.jar"]
