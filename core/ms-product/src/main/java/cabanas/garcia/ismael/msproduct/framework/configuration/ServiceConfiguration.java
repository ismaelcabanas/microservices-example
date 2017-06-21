package cabanas.garcia.ismael.msproduct.framework.configuration;

import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import cabanas.garcia.ismael.msproduct.domain.service.ProductService;
import cabanas.garcia.ismael.msproduct.domain.service.impl.DefaultProductService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new DefaultProductService(productRepository);
    }
}
