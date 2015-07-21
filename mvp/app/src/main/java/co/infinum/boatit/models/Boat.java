package co.infinum.boatit.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by kjurkovic on 16/07/15.
 */
public class Boat implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("title")
    private String boatName;

    @SerializedName("image_url")
    private String boatImage;

    @SerializedName("score")
    private int score;

    @SerializedName("creator")
    private User creator;

    @SerializedName("comments")
    private List<Comment> comments;

    public int getId() {
        return id;
    }

    public String getBoatName() {
        return boatName;
    }

    public String getBoatImage() {
        return boatImage;
    }

    public int getScore() {
        return score;
    }

    public User getCreator() {
        return creator;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public int getCommentsSize() {
        return comments != null && comments.size() > 0 ? comments.size() : 0;
    }
}
