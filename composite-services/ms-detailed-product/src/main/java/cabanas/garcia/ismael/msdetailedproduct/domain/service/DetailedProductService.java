package cabanas.garcia.ismael.msdetailedproduct.domain.service;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.ProductAggregated;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public interface DetailedProductService {
    ProductAggregated detailedProduct(int productId);
}
