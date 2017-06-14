package cabanas.garcia.ismael.msdetailedproduct.domain.service.impl;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.RecommendationRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.RecommendationService;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DefaultRecommendationService implements RecommendationService {

    private RecommendationRepository recommendationRepository;

    public DefaultRecommendationService(RecommendationRepository recommendationRepository) {
        this.recommendationRepository = recommendationRepository;
    }

    @Override
    public List<Recommendation> getRecommendations(int productId) {
        return recommendationRepository.find(productId);
    }
}
