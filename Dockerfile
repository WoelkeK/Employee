FROM openjdk:20-ea-31-jdk-oracle
VOLUME /Employee
ADD target/Employee-0.0.1-SNAPSHOT.jar Employee.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/Employee.jar"]

