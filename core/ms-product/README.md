# Product Microservice

Microservicio de productos.


## Build with Gradle

`./gradlew clean build`

### Ejecución de tests unitarios

`./gradlew clean test`

### Ejecución de tests integrados

`./gradlew clean integrationTest`

## Build with Maven

`mvn clean install`

### Ejecución de tests unitarios

`mvn clean test -P dev`

### Ejecución de tests integrados

`mvn clean verify -P integration-test`

## Run with Gradle

`./gradlew bootRun` o `PORT=8001 ./gradlew bootRun' si queremos establecer
la variable de entorno PORT para, en este caso, establecer el puerto donde
arrancará el microservicio.

Para debuggear el microservicio de forma remota `./gradlew bootRun --debug-jvm`

## Run with Maven

`mvn clean spring-boot:run` o `mvn clean spring-boot:run -DPORT=8001` si queremos establecer
la variable de entorno PORT para, en este caso, establecer el puerto donde
arrancará el microservicio

## Run with Docker

Para construir la imagen Docker previamente hay que construir el proyecto con Gradle,
ya que el Dockerfile está preparado para copiar el jar de la aplicación donde lo coloca Gradle.

Luego, colocarnos en el directorio donde está el fichero Dockerfile y ejecutar la instrucción

`docker build -t ismaelcabanas/ms-product:1.0.0 .`

Para arrancar un contenedor de la imagen Docker

`docker run -t --rm -p 8000:8000 --name ms-product ismaelcabanas/ms-product:1.0.0`

