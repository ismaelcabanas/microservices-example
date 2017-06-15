package cabanas.garcia.ismael.msdetailedproduct.domain.service.impl;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Product;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ProductRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DefaultProductService implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultProductService.class);

    private ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> read(int productId) {
        LOGGER.debug("Getting product {}", productId);

        Optional<Product> opProduct = Optional.ofNullable(productRepository.findById(productId));

        LOGGER.debug("Product founded is {}", opProduct);

        return opProduct;
    }
}
