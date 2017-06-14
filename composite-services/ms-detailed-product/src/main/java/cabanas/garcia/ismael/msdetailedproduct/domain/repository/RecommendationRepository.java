package cabanas.garcia.ismael.msdetailedproduct.domain.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public interface RecommendationRepository {
    List<Recommendation> find(int productId);
}
