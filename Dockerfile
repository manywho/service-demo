FROM maven:onbuild-alpine

EXPOSE 8080

CMD ["java", "-jar", "/usr/src/app/target/demo-1.0-SNAPSHOT.jar"]