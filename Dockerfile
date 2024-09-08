FROM openjdk:21-jdk-slim as jdk

FROM jdk as builder
WORKDIR /service

COPY . /service
RUN ./gradlew :website:bootJar --no-daemon

FROM jdk as runner
WORKDIR /service
COPY --from=builder /service/website/build/libs/service.jar /service/service.jar

EXPOSE 80
CMD ["java", "-jar", "./service.jar"]
