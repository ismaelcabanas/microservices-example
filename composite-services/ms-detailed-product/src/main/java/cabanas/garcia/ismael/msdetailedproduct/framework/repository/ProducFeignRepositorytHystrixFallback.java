package cabanas.garcia.ismael.msdetailedproduct.framework.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * Created by ismaelcabanas on 15/6/17.
 */
@Component
public class ProducFeignRepositorytHystrixFallback implements ProductFeignRepository {

    private static final Logger LOG = LoggerFactory.getLogger(ProducFeignRepositorytHystrixFallback.class);

    @Override
    public Product findById(int productId) {

        LOG.debug("Fallback findById method for product {}", productId);

        return Product.ProductBuilder.builder()
                .withName("Dummy Product")
                .withWeight(0)
                .build();
    }
}
