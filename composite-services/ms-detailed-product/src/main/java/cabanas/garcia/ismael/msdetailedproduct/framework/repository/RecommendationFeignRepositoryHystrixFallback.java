package cabanas.garcia.ismael.msdetailedproduct.framework.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismaelcabanas on 15/6/17.
 */
@Component
public class RecommendationFeignRepositoryHystrixFallback implements RecommendationFeignRepository{

    private static final Logger LOG = LoggerFactory.getLogger(RecommendationFeignRepositoryHystrixFallback.class);

    @Override
    public List<Recommendation> find(int productId) {
        LOG.debug("Fallback find method for product {}", productId);
        return new ArrayList<>();
    }
}
