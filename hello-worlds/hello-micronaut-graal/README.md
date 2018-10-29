# Hello Micronaut Graal

## Overview

A simple Micronaut hello world on GraalVM.

Only works on UNIX systems.

## Build (optional)

**Requires Graal SDK 1.0.0 RC7**

Get the SVM Dependency:

```
docker run oracle/graalvm-ce:1.0.0-rc7 cat /usr/java/latest/jre/lib/svm/builder/svm.jar > svm.jar

mvn install:install-file -Dfile=svm.jar \
                           -DgroupId=com.oracle.substratevm \
                           -DartifactId=svm \
                           -Dversion=GraalVM-1.0.0-rc7 \
                           -Dpackaging=jar
```

Build the Jar:

`./gradlew clean assemble`

Generate the reflection configuration file then build the native image:

```
java -cp build/libs/hello-micronaut-graal-0.1-all.jar io.micronaut.graal.reflect.GraalClassLoadingAnalyzer

native-image --no-server \
--class-path build/libs/hello-micronaut-graal-0.1-all.jar \
-H:ReflectionConfigurationFiles=build/reflect.json \
-H:EnableURLProtocols=http \
-H:IncludeResources="logback.xml|application.yml|META-INF/services/*.*" \
-H:Name=hello-micronaut-graal \
-H:Class=example.Application \
-H:+ReportUnsupportedElementsAtRuntime \
-H:+AllowVMInspection \
--rerun-class-initialization-at-runtime='sun.security.jca.JCAUtil$CachedSecureRandomHolder,javax.net.ssl.SSLContext' \
--delay-class-initialization-to-runtime=io.netty.handler.codec.http.HttpObjectEncoder,io.netty.handler.codec.http.websocketx.WebSocket00FrameEncoder,io.netty.handler.ssl.util.ThreadLocalInsecureRandom

```

## Run

A native image is provided if you didn't build it yourself.

Linux 64 bits: `./hello-micronaut-graal-linux`

Mac 64 bits: `./hello-micronaut-graal-mac`

The exposed resources is `localhost:8082/hello`