FROM gradle:7.5.0-jdk11-alpine as builder
USER root
WORKDIR /builder
ADD . /builder
RUN gradle assemble

FROM openjdk:11.0.16-jre-slim
WORKDIR /app
EXPOSE 8080
COPY --from=builder /builder/build/libs/06-02-error-handling-0.0.1.jar .
CMD ["java", "-jar", "06-02-error-handling-0.0.1.jar"]
