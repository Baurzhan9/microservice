FROM openjdk:8
ADD /target/docker-request.jar docker-request.jar
EXPOSE 8084
ENTRYPOINT ["java", "-jar", "docker-request.jar"]