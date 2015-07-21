package co.infinum.boatit.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class LoginRequest implements Serializable {

    @SerializedName("email")
    private String username;

    @SerializedName("password")
    private String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
