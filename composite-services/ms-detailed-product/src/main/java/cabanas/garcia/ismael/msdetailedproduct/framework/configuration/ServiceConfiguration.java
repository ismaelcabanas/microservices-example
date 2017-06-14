package cabanas.garcia.ismael.msdetailedproduct.framework.configuration;

import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ProductRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.RecommendationRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ReviewRepository;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.DetailedProductService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ProductService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.RecommendationService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.ReviewService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.impl.DefaultDetailedProductService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.impl.DefaultProductService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.impl.DefaultRecommendationService;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.impl.DefaultReviewService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
@Configuration
public class ServiceConfiguration {

    @Bean
    public ProductService productService(ProductRepository productRepository){
        return new DefaultProductService(productRepository);
    }

    @Bean
    public ReviewService reviewService(ReviewRepository reviewRepository){
        return new DefaultReviewService(reviewRepository);
    }

    @Bean
    public RecommendationService recommendationService(RecommendationRepository recommendationRepository){
        return new DefaultRecommendationService(recommendationRepository);
    }

    @Bean
    public DetailedProductService detailedProductService(ProductService productService,
                                                         ReviewService reviewService, RecommendationService recommendationService){
        return new DefaultDetailedProductService(productService, reviewService, recommendationService);
    }
}
