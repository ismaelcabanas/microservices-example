package cabanas.garcia.ismael.msproduct.framework.controller;

import cabanas.garcia.ismael.msproduct.domain.model.Product;
import cabanas.garcia.ismael.msproduct.domain.service.ProductNotExistException;
import cabanas.garcia.ismael.msproduct.domain.service.ProductService;
import cabanas.garcia.ismael.msproduct.framework.controller.apidocs.ProductControllerApiDocumentation;
import cabanas.garcia.ismael.msproduct.framework.dto.ProductResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@RestController
public class ProductController implements ProductControllerApiDocumentation{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Override
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductResponseDTO> getProduct(@PathVariable(required = true, value = "id") Long productId) {

        LOGGER.info("Getting product {}", productId);

        Product product = productService.getProduct(productId);

        ProductResponseDTO response = ProductResponseDTO.ProductResponseDTOBuilder.builder()
                .withId(product.getId())
                .withName(product.getName())
                .withWeight(product.getWeight())
                .build();

        LOGGER.debug("Response {}", response);

        return ResponseEntity.ok(response);

    }

    @ExceptionHandler(value = ProductNotExistException.class)
    public ResponseEntity<?> notExistProduct(ProductNotExistException ex){
        LOGGER.debug("Product {} not found", ex.getProductId());
        return ResponseEntity.notFound().build();
    }
}
