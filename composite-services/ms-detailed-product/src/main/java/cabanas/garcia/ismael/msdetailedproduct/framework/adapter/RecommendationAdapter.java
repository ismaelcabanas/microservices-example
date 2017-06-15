package cabanas.garcia.ismael.msdetailedproduct.framework.adapter;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;
import cabanas.garcia.ismael.msdetailedproduct.framework.dto.RecommendationResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ismaelcabanas on 15/6/17.
 */
public class RecommendationAdapter {
    public static List<RecommendationResponseDTO> map(List<Recommendation> recommendations) {
        return recommendations.stream().map(recommendation -> map(recommendation)).collect(Collectors.toList());
    }

    private static RecommendationResponseDTO map(Recommendation recommendation){
        return RecommendationResponseDTO.RecommendationResponseDTOBuilder.builder()
                .withAuthor(recommendation.getAuthor())
                .withContent(recommendation.getContent())
                .withRate(recommendation.getRate())
                .withRecommendationId(recommendation.getRecommendationId())
                .build();
    }
}
