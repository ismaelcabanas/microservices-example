# Recommendation products Microservice

Microservicio de recomendaciones productos.


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

`docker build -t ismaelcabanas/ms-recommendation:1.0.0 .`

Para arrancar un contenedor de la imagen Docker

`docker run -t --rm -p 8000:8000 --name ms-recommendation ismaelcabanas/ms-recommendation:1.0.0`

