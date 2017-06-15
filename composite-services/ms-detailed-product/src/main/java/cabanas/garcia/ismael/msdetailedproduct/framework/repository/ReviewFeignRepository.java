package cabanas.garcia.ismael.msdetailedproduct.framework.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ReviewRepository;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
@FeignClient(value = "ms-review", decode404 = true)
public interface ReviewFeignRepository extends ReviewRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/reviews?productId={productId}")
    @Override
    List<Review> find(@RequestParam(value = "productId") int productId);
}
