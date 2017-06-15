package cabanas.garcia.ismael.msdetailedproduct.framework.adapter;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.DetailedProduct;
import cabanas.garcia.ismael.msdetailedproduct.framework.dto.DetailedProductResponseDTO;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public final class DetailedProductAdapter {

    public static DetailedProductResponseDTO map(DetailedProduct detailedProduct) {
        return DetailedProductResponseDTO.DetailedProductResponseDTOBuilder.builder()
                .withId(detailedProduct.getProductId())
                .withName(detailedProduct.getProductName())
                .withWeight(detailedProduct.getProductWeight())
                .withReviews(ReviewAdapter.map(detailedProduct.getReviews()))
                .withRecommendations(RecommendationAdapter.map(detailedProduct.getRecommendations()))
                .build();
    }
}
