FROM adoptopenjdk/openjdk11:latest
ADD target/api-gateway.jar gateway.jar
ENTRYPOINT ["java","-jar","gateway.jar"]