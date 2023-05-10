FROM openjdk:17
COPY /patient-board-app/target/patient-board-app-1.0-SNAPSHOT.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","app.jar"]
