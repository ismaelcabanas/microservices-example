package cabanas.garcia.ismael.msdetailedproduct.domain.service.impl;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Product;
import cabanas.garcia.ismael.msdetailedproduct.domain.model.DetailedProduct;
import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;
import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.DetailedProductService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ProductService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.RecommendationService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ReviewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class DefaultDetailedProductService implements DetailedProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(DefaultDetailedProductService.class);

    private ProductService productService;

    private ReviewService reviewService;

    private RecommendationService recommendationService;

    public DefaultDetailedProductService(ProductService productService, ReviewService reviewService, RecommendationService recommendationService) {
        this.productService = productService;
        this.reviewService = reviewService;
        this.recommendationService = recommendationService;
    }

    @Override
    public DetailedProduct detailedProduct(int productId) {

        LOGGER.debug("Getting detailed for product {}", productId);

        Product product = productService.read(productId).orElseThrow(() -> new NoSuchElementException(String.format("Product with identifier %d not found", productId)));

        List<Review> productReviews = reviewService.getReviews(productId);

        List<Recommendation> productRecommendations = recommendationService.getRecommendations(productId);

        DetailedProduct detailedProduct = DetailedProduct.ProductAggregatedBuilder.builder()
                .withProduct(product)
                .withReviews(productReviews)
                .withRecommendations(productRecommendations)
                .build();

        LOGGER.debug("Detailed product {}", detailedProduct);

        return detailedProduct;
    }
}
