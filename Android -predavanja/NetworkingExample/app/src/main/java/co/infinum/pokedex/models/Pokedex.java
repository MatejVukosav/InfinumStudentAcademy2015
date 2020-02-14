package co.infinum.pokedex.models;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

/**
 * Created by kjurkovic on 11/07/15.
 */
public class Pokedex {

    @SerializedName("created")
    private Date createdAt;

    @SerializedName("modified")
    private Date modifiedAt;

    @SerializedName("pokemon")
    private List<Pokemon> pokemonList;

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }
}
