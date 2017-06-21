package cabanas.garcia.ismael.msproduct.domain.repository;

import cabanas.garcia.ismael.msproduct.domain.model.Product;

import java.util.Optional;

/**
 * Created by ismaelcabanas on 19/6/17.
 */
public interface ProductRepository {
    void create(Product product);

    Optional<Product> findById(Long productId);
}
