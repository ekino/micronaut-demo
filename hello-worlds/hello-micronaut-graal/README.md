# Hello Micronaut Graal

## Overview

A simple Micronaut hello world on GraalVM.

Only works on UNIX systems.

## Build (optional)

**Requires Graal SDK 19.x**

You can install it with SDKman:

`sdk install java 19.0.0-grl`

`sdk use java 19.0.0-grl`

Since the version 19.0, the native-image was extracted from the base distribution.

You have to install it with:

`gu install native-image` 

Then build the Jar:

`./gradlew clean assemble`

And then build the native image:

```
native-image --no-server \
             -H:IncludeResources="logback.xml|application.yml" \
             -jar build/libs/hello-micronaut-graal-0.1-all.jar \
             hello-micronaut-graal
```

## Run

A native image is provided if you didn't build it yourself.

Linux 64 bits: `./hello-micronaut-graal-linux`

Mac 64 bits: `./hello-micronaut-graal-mac`

The exposed resources is `localhost:8082/hello` and `localhost:8082/metrics`
