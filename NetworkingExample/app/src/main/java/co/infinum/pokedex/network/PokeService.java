package co.infinum.pokedex.network;

import co.infinum.pokedex.models.Pokedex;
import co.infinum.pokedex.models.Sprite;
import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Path;

/**
 * Created by kjurkovic on 11/07/15.
 */
public interface PokeService {

    @GET("/api/v1/pokedex/1/")
    void getPokedex(Callback<Pokedex> callback);

    @GET("/api/v1/sprite/{id}")
    void getSprite(@Path("id") int pokemonId, Callback<Sprite> callback);
}
