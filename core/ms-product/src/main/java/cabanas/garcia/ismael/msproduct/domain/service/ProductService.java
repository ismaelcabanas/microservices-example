package cabanas.garcia.ismael.msproduct.domain.service;

import cabanas.garcia.ismael.msproduct.domain.model.Product;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
public interface ProductService {
    void saveProduct(Product product);

    Product getProduct(Long productId);
}
