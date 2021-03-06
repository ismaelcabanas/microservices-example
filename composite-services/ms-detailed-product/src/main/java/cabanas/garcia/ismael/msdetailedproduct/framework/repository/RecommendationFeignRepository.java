package cabanas.garcia.ismael.msdetailedproduct.framework.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Recommendation;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.RecommendationRepository;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
@FeignClient(value = "ms-recommendation", decode404 = true, fallback = RecommendationFeignRepositoryHystrixFallback.class)
public interface RecommendationFeignRepository extends RecommendationRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/recommendations?productId={productId}")
    @Override
    List<Recommendation> find(@RequestParam(value = "productId") int productId);
}
