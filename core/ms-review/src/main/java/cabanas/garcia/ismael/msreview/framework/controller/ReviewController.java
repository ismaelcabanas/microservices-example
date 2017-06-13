package cabanas.garcia.ismael.msreview.framework.controller;

import cabanas.garcia.ismael.msreview.framework.controller.apidocs.ReviewControllerApiDocumentation;
import cabanas.garcia.ismael.msreview.framework.dto.ReviewResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
@RestController
public class ReviewController implements ReviewControllerApiDocumentation {

    @Override
    @RequestMapping(value = "/reviews", method = RequestMethod.GET)
    public ResponseEntity<List<ReviewResponseDTO>> getReviews(@RequestParam(required = true, value = "productId") int productId) {

        ReviewResponseDTO review1 = ReviewResponseDTO.ReviewResponseDTOBuilder.builder()
                .withReviewId(1)
                .withAuthor("Author 1")
                .withSubject("Subject 1")
                .withContent("Content 1")
                .withProductId(productId)
                .build();
        ReviewResponseDTO review2 = ReviewResponseDTO.ReviewResponseDTOBuilder.builder()
                .withReviewId(2)
                .withAuthor("Author 2")
                .withSubject("Subject 2")
                .withContent("Content 2")
                .withProductId(productId)
                .build();
        ReviewResponseDTO review3 = ReviewResponseDTO.ReviewResponseDTOBuilder.builder()
                .withReviewId(3)
                .withAuthor("Author 3")
                .withSubject("Subject 3")
                .withContent("Content 3")
                .withProductId(productId)
                .build();

        List<ReviewResponseDTO> response = new ArrayList<>();
        response.add(review1);
        response.add(review2);
        response.add(review3);

        return ResponseEntity.ok(response);

    }
}
