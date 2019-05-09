package com.progark.pokemonmasters.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.progark.pokemonmasters.R;
import com.progark.pokemonmasters.model.Pokemon;

import java.util.List;

import pl.droidsonroids.gif.GifDrawable;

public class PokeListAdapter extends ArrayAdapter<Pokemon> {


    public PokeListAdapter(Context context, List<Pokemon> pokemon) {
        super(context, 0, pokemon);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Pokemon pokemon = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        }
        String pokeSpecies = pokemon.getSpecies();
        String pokeNum = "p" + pokemon.getNum().toString();
        TextView tvSpecies = (TextView) convertView.findViewById(R.id.species);
        tvSpecies.setText(pokeSpecies);
        pokeSpecies = pokeSpecies.toLowerCase();
        int id;
        GifDrawable sprite;
        Drawable hmm;
        id = convertView.getResources().getIdentifier(pokeNum, "drawable", "com.progark.pokemonmasters");
        try {
            sprite = new GifDrawable( getContext().getResources(), id);
            tvSpecies.setCompoundDrawablesWithIntrinsicBounds(sprite, null, null, null);
        }
        catch (Exception e) {
            id = convertView.getResources().getIdentifier("pokeball", "drawable", "com.progark.pokemonmasters");
            hmm = ContextCompat.getDrawable(getContext(), id);
            tvSpecies.setCompoundDrawablesWithIntrinsicBounds(hmm, null, null, null);

        }
        return convertView;
    }
}
