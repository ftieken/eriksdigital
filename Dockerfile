FROM openjdk:8-jdk-alpine
RUN addgroup -S eriksdigital && adduser -S order-user -G eriksdigital
USER order-user:eriksdigital
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} eriksdigital-orders.jar
ENTRYPOINT ["java","-jar","/eriksdigital-orders.jar"]