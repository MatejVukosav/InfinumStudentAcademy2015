package co.infinum.boatit.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class Comment implements Serializable {

    @SerializedName("id")
    private int id;

    @SerializedName("content")
    private String content;

    @SerializedName("author")
    private User author;

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getAuthor() {
        return author;
    }
}
