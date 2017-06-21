package cabanas.garcia.ismael.msproduct.domain.service.impl;

import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.repository.ProductRepository;
import cabanas.garcia.ismael.msproduct.domain.service.ProductNotExistException;
import cabanas.garcia.ismael.msproduct.domain.service.ProductService;

import java.util.Optional;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
public class DefaultProductService implements ProductService {

    private final ProductRepository productRepository;

    public DefaultProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void saveProduct(Product product) {
        productRepository.create(product);
    }

    @Override
    public Product getProduct(Long productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);
        if(!optionalProduct.isPresent())
            throw new ProductNotExistException(productId);

        return optionalProduct.get();
    }
}
