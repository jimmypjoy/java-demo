FROM tomcat:8.5.41-jdk8

MAINTAINER Jimmy Joy "jimmy@yahoo1.com"

RUN rm -rf /usr/local/tomcat/webapps/*
COPY ./target/spring-demo-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/spring-demo.war

VOLUME /usr/local/tomcat/logs

#ENV JAVA_OPTS="=Dspring.profiles.active=spring-demo"

CMD ["catalina.sh", "run"]
