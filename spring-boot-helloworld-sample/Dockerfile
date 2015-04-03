FROM java:8
MAINTAINER albert.vanthart@enovation.nl
EXPOSE 8080
EXPOSE 8888
ADD target/spring-boot-helloworld-sample-1.0.0.BUILD-SNAPSHOT.jar /app/application.jar
WORKDIR /app/
CMD java -jar application.jar
