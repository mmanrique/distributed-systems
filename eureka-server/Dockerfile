FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/eureka-server-1.0.jar app.jar
EXPOSE 8761
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]