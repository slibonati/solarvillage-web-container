FROM maven:3.6.2-jdk-8
COPY ./ ./
RUN mvn clean package

FROM java:8
EXPOSE 8080
ADD /solar-village-web/target/solar-village-web-1.0-SNAPSHOT.jar solar-village-web-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "solar-village-web-1.0-SNAPSHOT.jar"]

