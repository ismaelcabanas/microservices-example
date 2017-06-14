package cabanas.garcia.ismael.msdetailedproduct.framework.controller;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.ProductAggregated;
import cabanas.garcia.ismael.msdetailedproduct.domain.service.DetailedProductService;
import cabanas.garcia.ismael.msdetailedproduct.framework.adapter.DetailedProductAdapter;
import cabanas.garcia.ismael.msdetailedproduct.framework.controller.apidocs.DetailedProductControllerApiDocumentation;
import cabanas.garcia.ismael.msdetailedproduct.framework.dto.ProductResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@RestController
public class DetailedProductController implements DetailedProductControllerApiDocumentation{

    private DetailedProductService detailedProductService;

    @Autowired
    public DetailedProductController(DetailedProductService detailedProductService) {
        this.detailedProductService = detailedProductService;
    }

    @Override
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductResponseDTO> getDetailedProduct(@PathVariable(required = true, value = "id") int id) {

        ProductAggregated product = detailedProductService.detailedProduct(id);

        ProductResponseDTO response = DetailedProductAdapter.map(product);

        return ResponseEntity.ok(response);

    }
}
