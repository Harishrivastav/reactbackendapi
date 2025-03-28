FROM openjdk:17
EXPOSE 8080
ADD target/reactbackendapi.jar reactbackendapi.jar
ENTRYPOINT [ "java", "-jar", "/reactbackendapi.jar"]
