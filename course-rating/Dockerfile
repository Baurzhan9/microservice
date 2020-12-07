FROM openjdk:8
ADD /target/docker-rating.jar docker-rating.jar
EXPOSE 8083
ENTRYPOINT ["java", "-jar", "docker-rating.jar"]