From openjdk:8
copy ./target/application-0.0.1-SNAPSHOT.jar application-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","application-0.0.1-SNAPSHOT.jar"]