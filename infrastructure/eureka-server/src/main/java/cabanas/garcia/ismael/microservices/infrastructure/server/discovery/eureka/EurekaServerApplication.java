package cabanas.garcia.ismael.microservices.infrastructure.server.discovery.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@SpringBootApplication
@EnableEurekaServer  // esta anotación indica que la aplicación va a actuar como un servidor Eureka
public class EurekaServerApplication {

    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");
        SpringApplication.run(EurekaServerApplication.class, args);
    }
}
