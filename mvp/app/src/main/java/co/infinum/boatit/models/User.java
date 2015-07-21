package co.infinum.boatit.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import co.infinum.boatit.enums.UserAuthorized;

/**
 * Created by kjurkovic on 20/07/15.
 */
public class User implements Serializable {

    @SerializedName("token")
    private String token;

    @SerializedName("first_name")
    private String firstName;

    @SerializedName("last_name")
    private String lastName;

    @SerializedName("email")
    private String email;

    @SerializedName("is_authorized")
    private UserAuthorized authorized;

    public String getToken() {
        return token;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public UserAuthorized getAuthorized() {
        return authorized;
    }
}
