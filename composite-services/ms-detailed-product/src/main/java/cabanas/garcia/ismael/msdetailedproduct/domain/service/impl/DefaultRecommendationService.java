package cabanas.garcia.ismael.msdetailedproduct.domain.service.impl;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.RecommendationRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.RecommendationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DefaultRecommendationService implements RecommendationService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultRecommendationService.class);

    private RecommendationRepository recommendationRepository;

    public DefaultRecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        LOGGER.debug("Getting recommendations for product {}", productId);

        List<Recommendation> recommendations = recommendationRepository.find(productId);

        LOGGER.debug("Product recommendations founded {}", recommendations);

        return recommendations;
    }
}
