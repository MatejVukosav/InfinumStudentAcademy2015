package co.infinum.pokedex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import co.infinum.pokedex.R;
import co.infinum.pokedex.models.Pokemon;

/**
 * Created by kjurkovic on 11/07/15.
 */
public class PokedexAdapter extends ArrayAdapter<Pokemon> {

    public PokedexAdapter(Context context, List<Pokemon> objects) {
        super(context, R.layout.list_item_pokemon, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_pokemon, parent, false);
            holder = new ViewHolder(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.pokemonName.setText(getItem(position).getName());
        return convertView;
    }

    static class ViewHolder {

        @Bind(R.id.pokemon_name)
        TextView pokemonName;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            view.setTag(this);
        }
    }
}
