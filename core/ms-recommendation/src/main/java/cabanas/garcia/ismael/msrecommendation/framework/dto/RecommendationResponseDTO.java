package cabanas.garcia.ismael.msrecommendation.framework.dto;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
public class RecommendationResponseDTO {
    private int productId;
    private int recommendationId;
    private String author;
    private int rate;
    private String content;

    public int getProductId() {
        return productId;
    }

    public int getRecommendationId() {
        return recommendationId;
    }

    public String getAuthor() {
        return author;
    }

    public int getRate() {
        return rate;
    }

    public String getContent() {
        return content;
    }


    public static final class RecommendationResponseDTOBuilder {
        private int productId;
        private int recommendationId;
        private String author;
        private int rate;
        private String content;

        private RecommendationResponseDTOBuilder() {
        }

        public static RecommendationResponseDTOBuilder builder() {
            return new RecommendationResponseDTOBuilder();
        }

        public RecommendationResponseDTOBuilder withProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public RecommendationResponseDTOBuilder withRecommendationId(int recommendationId) {
            this.recommendationId = recommendationId;
            return this;
        }

        public RecommendationResponseDTOBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public RecommendationResponseDTOBuilder withRate(int rate) {
            this.rate = rate;
            return this;
        }

        public RecommendationResponseDTOBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public RecommendationResponseDTO build() {
            RecommendationResponseDTO recommendationResponseDTO = new RecommendationResponseDTO();
            recommendationResponseDTO.author = this.author;
            recommendationResponseDTO.content = this.content;
            recommendationResponseDTO.rate = this.rate;
            recommendationResponseDTO.productId = this.productId;
            recommendationResponseDTO.recommendationId = this.recommendationId;
            return recommendationResponseDTO;
        }
    }
}
