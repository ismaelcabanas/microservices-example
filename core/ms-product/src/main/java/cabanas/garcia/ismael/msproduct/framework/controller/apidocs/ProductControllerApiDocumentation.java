package cabanas.garcia.ismael.msproduct.framework.controller.apidocs;

import cabanas.garcia.ismael.msproduct.framework.dto.ProductResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
public interface ProductControllerApiDocumentation {

    @ApiOperation(value = "getProduct", nickname = "getProduct", response = ProductResponseDTO.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    ResponseEntity<ProductResponseDTO> getProduct(@ApiParam(required = true, value = "id") Long productId);
}
