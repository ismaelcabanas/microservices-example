package cabanas.garcia.ismael.msdetailedproduct.domain.model;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class ProductAggregated {

    private Product product;

    private List<Review> reviews;

    private List<Recommendation> recommendations;

    public Product getProduct() {
        return product;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public List<Recommendation> getRecommendations() {
        return recommendations;
    }


    public static final class ProductAggregatedBuilder {
        private Product product;
        private List<Review> reviews;
        private List<Recommendation> recommendations;

        private ProductAggregatedBuilder() {
        }

        public static ProductAggregatedBuilder builder() {
            return new ProductAggregatedBuilder();
        }

        public ProductAggregatedBuilder withProduct(Product product) {
            this.product = product;
            return this;
        }

        public ProductAggregatedBuilder withReviews(List<Review> reviews) {
            this.reviews = reviews;
            return this;
        }

        public ProductAggregatedBuilder withRecommendations(List<Recommendation> recommendations) {
            this.recommendations = recommendations;
            return this;
        }

        public ProductAggregated build() {
            ProductAggregated productAggregated = new ProductAggregated();
            productAggregated.reviews = this.reviews;
            productAggregated.recommendations = this.recommendations;
            productAggregated.product = this.product;
            return productAggregated;
        }
    }
}
