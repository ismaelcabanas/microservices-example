package cabanas.garcia.ismael.msproduct.framework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@SpringBootApplication(scanBasePackages = {
        "cabanas.garcia.ismael.msproduct.framework.configuration",
        "cabanas.garcia.ismael.msproduct.framework.controller"
})
@EnableEurekaClient
@EnableSwagger2
public class Application {
    public static void main(String[] args){
        // this property sets a pretty output in actuator metrics
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");

        SpringApplication application = new SpringApplication(Application.class);
        application.addListeners(new ApplicationPidFileWriter("ms-product.pid"));
        application.run(args);
    }
}
