FROM openjdk:21-jdk

ARG JAR_FILE=./build/libs/toy-product-service-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=dev", "-jar", "/app.jar"]