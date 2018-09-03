FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD ./build/libs/split-test-service-1.0.jar app.jar
EXPOSE 8081
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar","--spring.profiles.active=container"]