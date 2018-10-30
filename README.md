# Micronaut Demo

## Overview

Demonstration of Micronaut's features through a simple microservices application and three hello worlds.

All subprojects have a dedicated README.

This repository was used as a demonstration for [an article on Ekino's blog (in french)](https://www.ekino.com/micronaut-le-microframework-pour-microservices/).

## Microservices

### Requirements

* JDK 8
* Docker Compose 1.19 +

A simple read-only Micronaut application with three microservices : [book](microservices/book), [user](microservices/user) and [borrowing](microservices/borrowing).

### Run

Run the discovery server first from project root:

`cd microservices/eureka-server && ./gradlew clean bootRun`

Then run each of the services in three other terminals from project root:

`cd microservices/book && ./gradlew clean run`

`cd microservices/borrowing && ./gradlew clean run`

`cd microservices/user && ./gradlew clean run`

All services will be automatically registered to Eureka and listed on [its dashboard](http://localhost:8761).

The exposed resources are:

* http://localhost:8080/borrowings and http://localhost:8080/borrowings/{borrowingId}
* http://localhost:8081/books and http://localhost:8081/books/{bookId}
* http://localhost:8082/users and http://localhost:8082/users/{userId}

### Testing the fallback is working

Stopping either the book or user service will automatically trigger the use of their respective fallbacks

## Hello Worlds

Three simple and comparable hello world applications in [Micronaut](hello-worlds/hello-micronaut), [Spring Boot](hello-worlds/hello-spring-boot) and [Micronaut as a Graal native image](hello-worlds/hello-micronaut-graal).

### Requirements

* JDK 8
* UNIX system (for the Graal native image only)
* Optional: Graal SDK 1.0.0-RC7 (for building the native image yourself)

### Run

Micronaut :

`cd hello-worlds/hello-micronaut && ./gradlew clean run`

Spring Boot :

`cd hello-worlds/hello-spring-boot && ./gradlew clean bootRun`

Micronaut with Graal :

Linux 64 bits: `./hello-worlds/hello-micronaut-graal/hello-micronaut-graal-linux`

Mac 64 bits: `./hello-worlds/hello-micronaut-graal/hello-micronaut-graal-mac`

Refer to [hello-micronaut-graal's README](hello-worlds/hello-micronaut-graal/README.md) for building the native image yourself.


The exposed resources are:

* http://localhost:8080/hello and http://localhost:8080/metrics
* http://localhost:8081/hello and http://localhost:8081/actuator/metrics
* http://localhost:8082/hello
