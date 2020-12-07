FROM openjdk:8
ADD /target/docker-common-service.jar docker-common-service.jar
EXPOSE 9200
ENTRYPOINT ["java", "-jar", "docker-common-service.jar"]