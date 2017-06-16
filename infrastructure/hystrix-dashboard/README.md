# Hystrix dashboard for monitoring


## Run with Docker

Para construir la imagen Docker previamente hay que construir el proyecto con Gradle,
ya que el Dockerfile está preparado para copiar el jar de la aplicación donde lo coloca Gradle.

Luego, colocarnos en el directorio donde está el fichero Dockerfile y ejecutar la instrucción

`docker build -t ismaelcabanas/hystrix-dashboard:1.0.0 .`

Para arrancar un contenedor de la imagen Docker

`docker run -t --rm -p 8080:8080 --name hystrix-dashboard ismaelcabanas/hystrix-dashboard:1.0.0`

