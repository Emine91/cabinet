FROM openjdk:latest
COPY ./target/cabinet-app.jar cabinet-app.jar
ENTRYPOINT ["java","-jar","cabinet-app.jar"]