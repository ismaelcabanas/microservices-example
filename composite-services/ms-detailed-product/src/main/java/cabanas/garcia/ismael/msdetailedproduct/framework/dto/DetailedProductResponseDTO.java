package cabanas.garcia.ismael.msdetailedproduct.framework.dto;

import java.util.List;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
public class DetailedProductResponseDTO {

    private int id;
    private String name;
    private int weight;

    private List<ReviewResponseDTO> reviews;

    private List<RecommendationResponseDTO> recommendations;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public List<ReviewResponseDTO> getReviews() {
        return reviews;
    }

    public List<RecommendationResponseDTO> getRecommendations() {
        return recommendations;
    }


    public static final class DetailedProductResponseDTOBuilder {
        private int id;
        private String name;
        private int weight;
        private List<ReviewResponseDTO> reviews;
        private List<RecommendationResponseDTO> recommendations;

        private DetailedProductResponseDTOBuilder() {
        }

        public static DetailedProductResponseDTOBuilder builder() {
            return new DetailedProductResponseDTOBuilder();
        }

        public DetailedProductResponseDTOBuilder withId(int id) {
            this.id = id;
            return this;
        }

        public DetailedProductResponseDTOBuilder withName(String name) {
            this.name = name;
            return this;
        }

        public DetailedProductResponseDTOBuilder withWeight(int weight) {
            this.weight = weight;
            return this;
        }

        public DetailedProductResponseDTOBuilder withReviews(List<ReviewResponseDTO> reviews) {
            this.reviews = reviews;
            return this;
        }

        public DetailedProductResponseDTOBuilder withRecommendations(List<RecommendationResponseDTO> recommendations) {
            this.recommendations = recommendations;
            return this;
        }

        public DetailedProductResponseDTO build() {
            DetailedProductResponseDTO detailedProductResponseDTO = new DetailedProductResponseDTO();
            detailedProductResponseDTO.id = this.id;
            detailedProductResponseDTO.weight = this.weight;
            detailedProductResponseDTO.reviews = this.reviews;
            detailedProductResponseDTO.recommendations = this.recommendations;
            detailedProductResponseDTO.name = this.name;
            return detailedProductResponseDTO;
        }
    }
}
