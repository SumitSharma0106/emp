FROM adoptopenjdk/openjdk11:latest
ADD target/cloud-config-server.jar config.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","config.jar"]