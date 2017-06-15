package cabanas.garcia.ismael.msdetailedproduct.domain.model;

/**
 * Created by ismaelcabanas on 14/6/17.
 */
public class Recommendation {
    private int recommendationId;
    private String author;
    private int rate;
    private String content;

    public int getRecommendationId() {
        return recommendationId;
    }

    public String getAuthor() {
        return author;
    }

    public int getRate() {
        return rate;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "Recommendation{" +
                "recommendationId=" + recommendationId +
                ", author='" + author + '\'' +
                ", rate=" + rate +
                ", content='" + content + '\'' +
                '}';
    }
}
