FROM openjdk:11
volume /tmp
add target/justasimplerpgtable-0.0.1-SNAPSHOT.jar app.jar
expose 8765
ENTRYPOINT ["java", "-jar", "/app.jar"]