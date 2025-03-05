FROM openjdk:17
ENV PORT 9092
EXPOSE 9092
ADD target/userregdocker.jar userregdocker.jar
ENTRYPOINT ["java","-jar", "/userregdocker.jar"]