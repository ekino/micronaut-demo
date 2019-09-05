# User Service

## Overview

The service responsible of managing the users ("readers" in our case).
It is required to start the Consule and Jaeger servers before starting it.

## Requirements
* JDK 11
* Docker Compose 1.19 +

## Notable Frameworks and Libraries
* Micronaut 1.2.0
* Java 11
* [JUnit5](https://junit.org/junit5/) with Micronaut's test suite and [AssertJ](http://joel-costigliola.github.io/assertj/)

## Test, Build and Run
### Test
`./gradlew test`

### Build
`./gradlew build`

### Run
`./gradlew run`

The exposed resources are http://localhost:8082/users and http://localhost:8082/users/{userId}.
