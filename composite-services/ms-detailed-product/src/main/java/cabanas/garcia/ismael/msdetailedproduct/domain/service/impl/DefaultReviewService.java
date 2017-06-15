package cabanas.garcia.ismael.msdetailedproduct.domain.service.impl;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ReviewRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DefaultReviewService implements ReviewService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultReviewService.class);

    private ReviewRepository reviewRepository;

    public DefaultReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> getReviews(int productId) {
        LOGGER.debug("Getting reviews for product {}", productId);

        List<Review> reviews = reviewRepository.find(productId);

        LOGGER.debug("Product reviews founded {}", reviews);

        return reviews;
    }
}
