FROM openjdk:20
COPY target/inventory_be-0.0.1-SNAPSHOT.jar inventory_be-0.0.1-SNAPSHOT.jar
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "/inventory_be-0.0.1-SNAPSHOT.jar"]