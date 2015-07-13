package co.infinum.pokedex.activities;

import com.bumptech.glide.Glide;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.pokedex.R;
import co.infinum.pokedex.models.Pokemon;
import co.infinum.pokedex.models.Sprite;
import co.infinum.pokedex.network.ApiManager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by kjurkovic on 13/07/15.
 */
public class DetailsActivity extends AppCompatActivity {

    public static final String POKEMON = "pokemon";

    @Bind(R.id.pokemon_image)
    ImageView pokemonImage;

    @Bind(R.id.pokemon_name)
    TextView pokemonName;

    private Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ButterKnife.bind(this);
        initUI();
    }

    private void initUI() {
        if (getIntent() != null) {
            pokemon = (Pokemon) getIntent().getSerializableExtra(POKEMON);
            pokemonName.setText(pokemon.getName());
            int pokemonId = pokemon.getPokemonId();
            if (pokemonId != Pokemon.INVALID_ID) {
                ApiManager.getService().getSprite(pokemonId, new Callback<Sprite>() {
                    @Override
                    public void success(Sprite sprite, Response response) {
                        Glide.with(DetailsActivity.this).load(sprite.getImage()).into(pokemonImage);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        Toast.makeText(DetailsActivity.this, "failed to load image", Toast.LENGTH_LONG).show();
                    }
                });
            }
        }
    }
}
