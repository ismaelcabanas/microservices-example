package cabanas.garcia.ismael.msproduct.framework.configuration;

import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import cabanas.garcia.ismael.msproduct.framework.repository.PostgresProductRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
@Configuration
public class RepositoryConfiguration {

    @Bean
    public ProductRepository productRepository(JdbcTemplate jdbcTemplate){
        return new PostgresProductRepository(jdbcTemplate);
    }
}
