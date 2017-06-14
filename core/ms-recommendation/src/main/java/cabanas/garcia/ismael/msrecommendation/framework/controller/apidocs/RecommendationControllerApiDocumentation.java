package cabanas.garcia.ismael.msrecommendation.framework.controller.apidocs;

import cabanas.garcia.ismael.msrecommendation.framework.dto.RecommendationResponseDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
public interface RecommendationControllerApiDocumentation {

    @ApiOperation(value = "getRecommendations", nickname = "getRecommendations", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = List.class),
            @ApiResponse(code = 201, message = "Created"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    ResponseEntity<List<RecommendationResponseDTO>> getRecommendations(@ApiParam(required = true, value = "productId") int productId);
}
