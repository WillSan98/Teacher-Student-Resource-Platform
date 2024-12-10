
package Group3_CSC340.TSRP_Backend.Review;

import Group3_CSC340.TSRP_Backend.student.Student;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Date;


@Entity
@Table(name ="reviews")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int review_id;

    private String  reviewText;


    public Review(int review_id, String reviewText) {
        this.review_id = review_id;

        this.reviewText = reviewText;


    }

    public Review(String reviewText) {

        this.reviewText = reviewText;

    }

    public Review() {

    }

    public int getReview_id() {
        return review_id;
    }

    public void setReview_id(int review_id) {
        this.review_id = review_id;
    }



    public String getReviewText() {
        return reviewText;
    }

    public void setReviewText(String reviewText) {
        this.reviewText = reviewText;
    }


}
