# Book Service

## Overview

The service responsible of managing the books.
It is required to start the Consule and Jaeger servers before starting it.

## Requirements
* JDK 11
* Docker Compose 1.19 +

## Notable Frameworks and Libraries
* Micronaut 1.2.0
* Java 11
* [Spok](http://spockframework.org/) with Micronaut's test suite

## Test, Build and Run
### Test
`./gradlew test`

### Build
`./gradlew build`

### Run
`./gradlew run`

The exposed resources are http://localhost:8081/book` and http://localhost:8081/books/{bookId}.
