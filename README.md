# spring-boot-admin

Spring Boot Admin provides a simple admin interface for Spring Boot applications.

Features:

* Show name/id and version number
* Show health status
* Show metrics
* Set log level
* Interact with JMX-Beans
* View Threaddump
* View Traces

For more info see: https://github.com/codecentric/spring-boot-admin

# How to build

```
$ mvn package
```

# How to run locally

You need Docker and Docker Compose to run the Spring Boot Admin and the sample project in Docker containers.

```
$ docker-compose up
```

Go to http://docker-ip:18080 to see a list of runnning applications.

Go to http://docker-ip:8500 to open the Consul UI

Start more helloworld instances with

```
$ docker-compose scale helloworld=3
```

# Todo

* Test multiple instances in Spring Boot Admin?
* Filter services by tag: https://github.com/spring-cloud/spring-cloud-consul/issues/18 and https://github.com/spring-cloud/spring-cloud-commons/issues/19 