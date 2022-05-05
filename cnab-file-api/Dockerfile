FROM maven:3.8.3-openjdk-17 as build

COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests

FROM openjdk:17-jdk

COPY --from=build /home/app/target/cnab-file-api-0.0.1-SNAPSHOT.jar /usr/local/lib/cnab-file-api.jar

ENTRYPOINT ["java","-jar","/usr/local/lib/cnab-file-api.jar"]