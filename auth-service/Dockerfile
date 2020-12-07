FROM openjdk:8
ADD /target/docker-auth-service.jar docker-auth-service.jar
EXPOSE 9100
ENTRYPOINT ["java", "-jar", "docker-auth-service.jar"]