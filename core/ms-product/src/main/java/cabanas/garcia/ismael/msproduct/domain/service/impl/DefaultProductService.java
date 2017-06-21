package cabanas.garcia.ismael.msproduct.domain.service.impl;

import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import cabanas.garcia.ismael.msproduct.domain.service.ProductService;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void save(Product product) {
        productRepository.create(product);
    }
}
