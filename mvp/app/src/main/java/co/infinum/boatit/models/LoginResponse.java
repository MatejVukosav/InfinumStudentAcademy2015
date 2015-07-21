package co.infinum.boatit.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class LoginResponse implements Serializable{

    @SerializedName("response")
    private User user;

    public User getUser() {
        return user;
    }
}
