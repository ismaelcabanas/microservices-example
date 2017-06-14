package cabanas.garcia.ismael.msdetailedproduct.framework.repository;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Product;
import cabanas.garcia.ismael.msdetailedproduct.domain.repository.ProductRepository;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
@FeignClient(value = "ms-product", decode404 = true)
public interface ProductFeignRepository extends ProductRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/products/{id}")
    @Override
    Product findById(@PathVariable("id") int productId);
}
