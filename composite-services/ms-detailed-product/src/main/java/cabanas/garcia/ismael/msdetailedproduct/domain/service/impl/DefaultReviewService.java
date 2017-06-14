package cabanas.garcia.ismael.msdetailedproduct.domain.service.impl;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ReviewRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ReviewService;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DefaultReviewService implements ReviewService {

    private ReviewRepository reviewRepository;

    public DefaultReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviews(int productId) {
        return reviewRepository.find(productId);
    }
}
