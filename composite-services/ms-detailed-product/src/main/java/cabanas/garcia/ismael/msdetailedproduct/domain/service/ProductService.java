package cabanas.garcia.ismael.msdetailedproduct.domain.service;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Product;

import java.util.Optional;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public interface ProductService {
    Optional<Product> read(int productId);
}
