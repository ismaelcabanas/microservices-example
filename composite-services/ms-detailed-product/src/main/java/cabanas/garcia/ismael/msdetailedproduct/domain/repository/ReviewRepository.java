package cabanas.garcia.ismael.msdetailedproduct.domain.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public interface ReviewRepository {
    List<Review> find(int productId);
}
