package cabanas.garcia.ismael.msdetailedproduct.domain.service;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public interface RecommendationService {
    List<Recommendation> getRecommendations(int productId);
}
