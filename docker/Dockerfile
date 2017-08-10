FROM openjdk:8u111-jdk-alpine

MAINTAINER suresh26272@gmail.com

# setup group and user, initialize home
RUN addgroup -g 30001 account-service && \
    adduser -h /app -S -s /sbin/nologin -u 30001 account-service

COPY account-service.jar /app

RUN chown -R account-service /app

# 8000 = debug port
# 8080 = api port
# 9080 = management port
EXPOSE 8000 8080 9080

USER account-service
WORKDIR app

CMD ["java", "-jar", "/account-service.jar"]