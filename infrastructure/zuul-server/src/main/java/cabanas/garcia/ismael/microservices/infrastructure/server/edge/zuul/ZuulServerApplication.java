package cabanas.garcia.ismael.microservices.infrastructure.server.edge.zuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by ismaelcabanas on 15/6/17.
 */
@SpringBootApplication
@EnableZuulProxy
public class ZuulServerApplication {

    private static final Logger LOG = LoggerFactory.getLogger(ZuulServerApplication.class);

    public static void main(String[] args) {
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");

        LOG.info("Initializing Edge Server implemented by Zuul");

        SpringApplication zuulServerApplication = new SpringApplication(ZuulServerApplication.class);
        zuulServerApplication.addListeners(new ApplicationPidFileWriter("zuul-server.pid"));
        zuulServerApplication.run(args);

        LOG.info("Edge Server started");
    }
}
