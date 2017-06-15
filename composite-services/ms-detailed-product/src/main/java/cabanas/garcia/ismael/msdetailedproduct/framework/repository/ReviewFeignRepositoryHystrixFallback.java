package cabanas.garcia.ismael.msdetailedproduct.framework.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismaelcabanas on 15/6/17.
 */
@Component
public class ReviewFeignRepositoryHystrixFallback implements ReviewFeignRepository{

    private static final Logger LOG = LoggerFactory.getLogger(ReviewFeignRepositoryHystrixFallback.class);

    @Override
    public List<Review> find(int productId) {
        LOG.debug("Fallback find method for product {}", productId);
        return new ArrayList<>();
    }
}
