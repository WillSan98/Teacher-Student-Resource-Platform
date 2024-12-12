
package Group3_CSC340.TSRP_Backend.Posts;

import Group3_CSC340.TSRP_Backend.student.Student;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int postId;

    private String postText;

    public Posts(int postId, String postText) {
        this.postId = postId;

        this.postText = postText;
    }

    public Posts(String postText) {

        this.postText = postText;
    }

    public Posts() {

    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }



    public String getPostText() {
        return postText;
    }

    public void setPostText(String postText) {
        this.postText = postText;
    }
}
