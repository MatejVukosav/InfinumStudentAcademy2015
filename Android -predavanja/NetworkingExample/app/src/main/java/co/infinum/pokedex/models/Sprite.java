package co.infinum.pokedex.models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import co.infinum.pokedex.network.ApiManager;

/**
 * Created by kjurkovic on 13/07/15.
 */
public class Sprite implements Serializable {

    @SerializedName("image")
    private String image;

    public String getImage() {
        return ApiManager.API_ENDPOINT + image;
    }
}
