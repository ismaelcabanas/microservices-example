package cabanas.garcia.ismael.infrastructure.monitor.hystrix;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Created by ismaelcabanas on 16/6/17.
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashboardApplication {

    private static final Logger LOG = LoggerFactory.getLogger(HystrixDashboardApplication.class);

    public static void main(String[] args){
        System.setProperty("spring.jackson.serialization.INDENT_OUTPUT", "true");

        LOG.info("Initializing Hystrix Dashboard Monitor");

        SpringApplication eurekaServerApplication = new SpringApplication(HystrixDashboardApplication.class);
        eurekaServerApplication.addListeners(new ApplicationPidFileWriter("hystrix-dashboard.pid"));
        eurekaServerApplication.run(args);

        LOG.info("Hystrix Dashboard Monitor started");
    }
}
