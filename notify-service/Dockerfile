FROM openjdk:8
ADD /target/docker-notify-service.jar docker-notify-service.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "docker-notify-service.jar"]