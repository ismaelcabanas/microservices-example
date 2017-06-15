package cabanas.garcia.ismael.msdetailedproduct.domain.model;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class Review {
    private int reviewId;
    private String author;
    private String subject;
    private String content;

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", author='" + author + '\'' +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                '}';
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
}
