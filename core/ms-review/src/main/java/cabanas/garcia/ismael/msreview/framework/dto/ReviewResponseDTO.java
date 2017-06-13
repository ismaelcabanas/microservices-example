package cabanas.garcia.ismael.msreview.framework.dto;

/**
 * Created by ismaelcabanas on 13/6/17.
 */
public class ReviewResponseDTO {
    private int productId;
    private int reviewId;
    private String author;
    private String subject;
    private String content;

    public int getProductId() {
        return productId;
    }

    public int getReviewId() {
        return reviewId;
    }

    public String getAuthor() {
        return author;
    }

    public String getSubject() {
        return subject;
    }

    public String getContent() {
        return content;
    }


    public static final class ReviewResponseDTOBuilder {
        private int productId;
        private int reviewId;
        private String author;
        private String subject;
        private String content;

        private ReviewResponseDTOBuilder() {
        }

        public static ReviewResponseDTOBuilder builder() {
            return new ReviewResponseDTOBuilder();
        }

        public ReviewResponseDTOBuilder withProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public ReviewResponseDTOBuilder withReviewId(int reviewId) {
            this.reviewId = reviewId;
            return this;
        }

        public ReviewResponseDTOBuilder withAuthor(String author) {
            this.author = author;
            return this;
        }

        public ReviewResponseDTOBuilder withSubject(String subject) {
            this.subject = subject;
            return this;
        }

        public ReviewResponseDTOBuilder withContent(String content) {
            this.content = content;
            return this;
        }

        public ReviewResponseDTO build() {
            ReviewResponseDTO reviewResponseDTO = new ReviewResponseDTO();
            reviewResponseDTO.reviewId = this.reviewId;
            reviewResponseDTO.productId = this.productId;
            reviewResponseDTO.content = this.content;
            reviewResponseDTO.author = this.author;
            reviewResponseDTO.subject = this.subject;
            return reviewResponseDTO;
        }
    }
}
