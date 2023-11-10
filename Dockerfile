FROM openjdk:20-ea-31-jdk-oracle
VOLUME /employee
ADD target/employee-0.0.1-SNAPSHOT.jar employee.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar","/Employee.jar"]

