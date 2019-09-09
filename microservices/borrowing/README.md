# Borrowing Service

## Overview

The service responsible of managing the borrowings of books by users.
It is required to start the Consul and Jaeger servers before starting it.

## Requirements
* JDK 11
* Docker Compose 1.19 +

## Notable Frameworks and Libraries
* Micronaut 1.2.0
* Java 11
* Micronaut's reactive clients + fallback system
* [JUnit5](https://junit.org/junit5/) with Micronaut's test suite and [AssertJ](http://joel-costigliola.github.io/assertj/)

## Test, Build and Run
### Test
`./gradlew test`

### Build
`./gradlew build`

### Run
`./gradlew run`

The exposed resources are http://localhost:8080/borrowings and http://localhost:8080/borrowings/{borrowingId}.

## Testing the fallback is working

Stopping either the book or user service will automatically trigger the use of their respective fallbacks
