package co.infinum.pokedex.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.pokedex.R;
import co.infinum.pokedex.adapters.PokedexAdapter;
import co.infinum.pokedex.models.Pokedex;
import co.infinum.pokedex.network.ApiManager;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    @Bind(R.id.list_view)
    ListView pokeList;

    private PokedexAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        getPokedex();
    }

    private void getPokedex() {
        ApiManager.getService().getPokedex(new Callback<Pokedex>() {
            @Override
            public void success(Pokedex pokedex, Response response) {
                adapter = new PokedexAdapter(MainActivity.this, pokedex.getPokemonList());
                pokeList.setAdapter(adapter);
                pokeList.setOnItemClickListener(MainActivity.this);
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(DetailsActivity.POKEMON, adapter.getItem(position));
        startActivity(intent);
    }
}
