cd /Users/ismaelcabanas/development/myprojects/microservices-example/infrastructure/eureka-server/
./gradlew bootRun &

cd /Users/ismaelcabanas/development/myprojects/microservices-example/infrastructure/zuul-server/
./gradlew bootRun &

cd /Users/ismaelcabanas/development/myprojects/microservices-example/core/ms-product/
./gradlew bootRun &

cd /Users/ismaelcabanas/development/myprojects/microservices-example/core/ms-review/
./gradlew bootRun &

cd /Users/ismaelcabanas/development/myprojects/microservices-example/core/ms-recommendation/
./gradlew bootRun &

cd /Users/ismaelcabanas/development/myprojects/microservices-example/composite-services/ms-detailed-product/
./gradlew bootRun &

cd /Users/ismaelcabanas/development/myprojects/microservices-example/infrastructure/hystrix-dashboard/
./gradlew bootRun &
