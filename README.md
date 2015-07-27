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

# How to run

```
$ docker run -P depot.enovation.nl/wharf/spring-boot-admin
```

With consul as discovery registry:

```
$ docker run -P -e DISCOVERY_ENABLED=true -e CONSUL_HOST=192.168.99.100 depot.enovation.nl/wharf/spring-boot-admin
```

# How to run locally with all dependencies

You need Docker Compose to run Consul, Registrator, Spring Boot Admin and the Spring Boot sample project.

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

* Filter services by tag: https://github.com/spring-cloud/spring-cloud-consul/issues/18 and https://github.com/spring-cloud/spring-cloud-commons/issues/19 
