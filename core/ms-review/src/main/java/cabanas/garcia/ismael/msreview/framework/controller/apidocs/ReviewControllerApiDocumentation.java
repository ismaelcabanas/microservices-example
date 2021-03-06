package cabanas.garcia.ismael.msreview.framework.controller.apidocs;

import cabanas.garcia.ismael.msreview.framework.dto.ReviewResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
public interface ReviewControllerApiDocumentation {

    @ApiOperation(value = "getReviews", nickname = "getReviews", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    ResponseEntity<List<ReviewResponseDTO>> getReviews(@ApiParam(required = true, value = "id") int productId);
}
