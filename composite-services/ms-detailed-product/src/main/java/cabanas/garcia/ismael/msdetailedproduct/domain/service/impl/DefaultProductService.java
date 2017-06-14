package cabanas.garcia.ismael.msdetailedproduct.domain.service.impl;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Product;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ProductRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ProductService;

import java.util.Optional;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DefaultProductService implements ProductService {

    private ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Optional<Product> read(int productId) {
        return Optional.ofNullable(productRepository.findById(productId));
    }
}
