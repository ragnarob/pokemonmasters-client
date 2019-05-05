package com.progark.pokemonmasters.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.progark.pokemonmasters.R;
import com.progark.pokemonmasters.model.Pokemon;

import java.util.List;

public class PokeListAdapter extends ArrayAdapter<Pokemon> {

    public PokeListAdapter(Context context, List<Pokemon> pokemon) {
        super(context, 0, pokemon);
    }
//    private PokemonList pokeList;
//
//    @Override
//    public int getCount() {
//        return pokeList.size();
//    }
//
//    @Override
//    public Pokemon getItem(int i) {
//        return pokeList.getAPokemon(i);
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return pokeList.getPokemonId(i);
//    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon pokemon = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        }
        TextView tvSpecies = (TextView) convertView.findViewById(R.id.tvSpecies);

        tvSpecies.setText(pokemon.getSpecies());
        return convertView;
    }
}
