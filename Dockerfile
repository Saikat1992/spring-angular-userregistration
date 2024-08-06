FROM openjdk:17-jdk
EXPOSE 10001
ADD target/spring-boot-docker.jar spring-boot-docker.jar
ENTRYPOINT ["java","-jar", "/spring-boot-docker.jar"]