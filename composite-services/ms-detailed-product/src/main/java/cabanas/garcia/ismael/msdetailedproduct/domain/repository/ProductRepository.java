package cabanas.garcia.ismael.msdetailedproduct.domain.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Product;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public interface ProductRepository {
    Product findById(int productId);
}
