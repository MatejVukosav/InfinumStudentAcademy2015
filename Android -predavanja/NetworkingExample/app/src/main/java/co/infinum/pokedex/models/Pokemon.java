package co.infinum.pokedex.models;

import com.google.gson.annotations.SerializedName;

import android.text.TextUtils;

import java.io.Serializable;

/**
 * Created by kjurkovic on 11/07/15.
 */
public class Pokemon implements Serializable {

    public static final int INVALID_ID = -1;

    @SerializedName("resource_uri")
    private String resourceUri;

    @SerializedName("name")
    private String name;

    public int getPokemonId() {
        if (!TextUtils.isEmpty(resourceUri)) {
            try {
                String parsed = resourceUri.replace("api/v1/pokemon/", "").replace("/", "");
                return Integer.parseInt(parsed);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
            }
        }
        return INVALID_ID;
    }

    public String getName() {
        return name;
    }
}
