# Reviews products Microservice

Microservicio de revisiones de productos productos.


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

`docker build -t ismaelcabanas/ms-review:1.0.0 .`

Para arrancar un contenedor de la imagen Docker

`docker run -t --rm -p 8000:8000 --name ms-review ismaelcabanas/ms-review:1.0.0`

