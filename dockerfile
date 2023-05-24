FROM maven:3.8-amazoncorretto-11 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package -DskipTests


FROM openjdk:11
COPY --from=build /home/app/target/demo-app.jar /usr/local/lib/demo-app.jar
ENTRYPOINT ["java","-jar","/usr/local/lib/demo-app.jar"]
EXPOSE 8080
