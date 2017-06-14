package cabanas.garcia.ismael.msrecommendation.framework.controller;

import cabanas.garcia.ismael.msrecommendation.framework.controller.apidocs.RecommendationControllerApiDocumentation;
import cabanas.garcia.ismael.msrecommendation.framework.dto.RecommendationResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@RestController
public class RecommendationController implements RecommendationControllerApiDocumentation {

    @Override
    @RequestMapping(value = "/recommendations", method = RequestMethod.GET)
    public ResponseEntity<List<RecommendationResponseDTO>> getRecommendations(@RequestParam(required = true, value = "productId") int productId) {

        RecommendationResponseDTO recommendation1 = RecommendationResponseDTO.RecommendationResponseDTOBuilder.builder()
                .withRecommendationId(1)
                .withAuthor("Author 1")
                .withRate(10)
                .withContent("Content 1")
                .withProductId(productId)
                .build();
        RecommendationResponseDTO recommendation2 = RecommendationResponseDTO.RecommendationResponseDTOBuilder.builder()
                .withRecommendationId(2)
                .withAuthor("Author 2")
                .withRate(20)
                .withContent("Content 2")
                .withProductId(productId)
                .build();
        RecommendationResponseDTO recommendation3 = RecommendationResponseDTO.RecommendationResponseDTOBuilder.builder()
                .withRecommendationId(3)
                .withAuthor("Author 3")
                .withRate(30)
                .withContent("Content 3")
                .withProductId(productId)
                .build();

        List<RecommendationResponseDTO> response = new ArrayList<>();
        response.add(recommendation1);
        response.add(recommendation2);
        response.add(recommendation3);

        return ResponseEntity.ok(response);

    }
}
