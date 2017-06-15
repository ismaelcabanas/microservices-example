package cabanas.garcia.ismael.msdetailedproduct.domain.model;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DetailedProduct {

    private Product product;

    private List<Review> reviews;

    private List<Recommendation> recommendations;

    public int getProductId(){
        return this.product.getId();
    }

    public int getProductWeight(){
        return this.product.getWeight();
    }

    public String getProductName(){
        return this.product.getName();
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

        public DetailedProduct build() {
            DetailedProduct detailedProduct = new DetailedProduct();
            detailedProduct.reviews = this.reviews;
            detailedProduct.recommendations = this.recommendations;
            detailedProduct.product = this.product;
            return detailedProduct;
        }
    }
}
