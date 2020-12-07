FROM openjdk:8
ADD /target/docker-discovery.jar docker-discovery.jar
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "docker-discovery.jar"]