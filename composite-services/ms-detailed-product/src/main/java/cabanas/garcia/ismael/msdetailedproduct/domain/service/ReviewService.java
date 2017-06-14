package cabanas.garcia.ismael.msdetailedproduct.domain.service;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public interface ReviewService {
    List<Review> getReviews(int productId);
}
