FROM adoptopenjdk/openjdk11:latest
ADD target/git-config-server.jar git-config.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","git-config.jar"]