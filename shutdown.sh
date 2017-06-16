cd /Users/ismaelcabanas/development/myprojects/microservices-example/

kill $(cat infrastructure/eureka-server/eureka-server.pid)
kill $(cat infrastructure/zuul-server/zuul-server.pid)
kill $(cat core/ms-product/ms-product.pid)
kill $(cat core/ms-review/ms-review.pid)
kill $(cat core/ms-recommendation/ms-recommendation.pid)
kill $(cat composite-services/ms-detailed-product/ms-detailed-product.pid)
