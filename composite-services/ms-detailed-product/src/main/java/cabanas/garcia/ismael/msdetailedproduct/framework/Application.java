package cabanas.garcia.ismael.msdetailedproduct.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.msdetailedproduct.framework.configuration",
        "cabanas.garcia.ismael.msdetailedproduct.framework.controller",
        "cabanas.garcia.ismael.msdetailedproduct.framework.repository"
})
@EnableEurekaClient
@EnableSwagger2
@EnableFeignClients
@EnableCircuitBreaker
public class Application {
    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(Application.class, args);
    }
}
