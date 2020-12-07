FROM openjdk:8
ADD /target/docker-zuul-server.jar docker-zuul-server.jar
EXPOSE 9000
ENTRYPOINT ["java", "-jar", "docker-zuul-server.jar"]