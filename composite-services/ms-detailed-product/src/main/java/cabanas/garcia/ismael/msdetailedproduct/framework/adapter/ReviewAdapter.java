package cabanas.garcia.ismael.msdetailedproduct.framework.adapter;

import cabanas.garcia.ismael.msdetailedproduct.domain.model.Review;
import cabanas.garcia.ismael.msdetailedproduct.framework.dto.ReviewResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ismaelcabanas on 15/6/17.
 */
public final class ReviewAdapter {
    public static List<ReviewResponseDTO> map(List<Review> reviews) {
        return reviews.stream().map(review -> map(review)).collect(Collectors.toList());
    }

    private static ReviewResponseDTO map(Review review){
        return ReviewResponseDTO.ReviewResponseDTOBuilder.builder()
                .withAuthor(review.getAuthor())
                .withContent(review.getContent())
                .withReviewId(review.getReviewId())
                .withSubject(review.getSubject())
                .build();
    }
}
