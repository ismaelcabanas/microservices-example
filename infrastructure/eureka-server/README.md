# Services Discovery Server

A service discovery server microservice based on Eureka.

## Build with Gradle

`./gradlew build`

## Build with Maven

`mvn clean install`

## Run with Gradle

`./gradlew bootRun`

## Run with Maven

`mvn clean spring-boot:run

## Run with Docker

Para construir la imagen Docker previamente hay que construir el proyecto con Gradle,
ya que el Dockerfile está preparado para copiar el jar de la aplicación donde lo coloca Gradle.

Luego, colocarnos en el directorio donde está el fichero Dockerfile y ejecutar la instrucción

`docker build -t ismaelcabanas/eureka-server:1.0.0 .`

Para arrancar un contenedor de la imagen Docker

`docker run -t --rm -p 8761:8761 --name eureka-server ismaelcabanas/eureka-server:1.0.0`

