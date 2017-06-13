package cabanas.garcia.ismael.msproduct.framework.controller;

import cabanas.garcia.ismael.msproduct.framework.controller.apidocs.ProductControllerApiDocumentation;
import cabanas.garcia.ismael.msproduct.framework.dto.ProductResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@RestController
public class ProductController implements ProductControllerApiDocumentation{

    @Override
    @RequestMapping(value = "/products/{id}", method = RequestMethod.GET)
    public ResponseEntity<ProductResponseDTO> read(@PathVariable(required = true, value = "id") int id) {

        ProductResponseDTO response = ProductResponseDTO.ProductResponseDTOBuilder.aProductResponseDTO()
                .withId(id)
                .withName("Test product")
                .withWeight(100)
                .build();

        return ResponseEntity.ok(response);

    }
}
