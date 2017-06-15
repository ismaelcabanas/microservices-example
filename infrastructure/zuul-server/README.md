# Edge Server implementado por Zuul

Zuul es el servidor Netflix que actúa como enrutador y balanceador de
carga.

Zuul utiliza Ribbon para balancear la carga entre microservicios.

Es como exponer un punto de entrada de acceso a nuestro ecosistema de
microservicios. En este punto podemos aplicar seguridad a nuestros microservicios.

## Run with Docker

Para construir la imagen Docker previamente hay que construir el proyecto con Gradle,
ya que el Dockerfile está preparado para copiar el jar de la aplicación donde lo coloca Gradle.

Luego, colocarnos en el directorio donde está el fichero Dockerfile y ejecutar la instrucción

`docker build -t ismaelcabanas/zuul-server:1.0.0 .`

Para arrancar un contenedor de la imagen Docker

`docker run -t --rm -p 8080:8080 --name zuul-server ismaelcabanas/zuul-server:1.0.0`

## Comprobar los enrutamientos

Una vez el servidor Zuul se ha desplegado, se puede consultar el endpoint **/routes**
para verfificar los enrutamientos disponibles.