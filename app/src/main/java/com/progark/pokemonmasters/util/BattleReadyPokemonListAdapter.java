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

public class BattleReadyPokemonListAdapter extends ArrayAdapter<BattleReadyPokemon> {


    public BattleReadyPokemonListAdapter(Context context, List<BattleReadyPokemon> battleReadyPokemon) {
        super(context, 0, battleReadyPokemon);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BattleReadyPokemon battleReadyPokemon = getItem(position);
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pokemon, parent, false);
        }
        String pokeSpecies = battleReadyPokemon.getSpecies();
        String pokeId = "p" + battleReadyPokemon.getId();
        TextView species = (TextView) convertView.findViewById(R.id.species);
        species.setText(pokeSpecies);

        int id;
        GifDrawable sprite;
        Drawable hmm;
        id = convertView.getResources().getIdentifier(pokeId, "drawable", "com.progark.pokemonmasters");
        try {
            sprite = new GifDrawable( getContext().getResources(), id);
            species.setCompoundDrawablesWithIntrinsicBounds(sprite, null, null, null);
        }
        catch (Exception e) {
            id = convertView.getResources().getIdentifier("pokeball", "drawable", "com.progark.pokemonmasters");
            hmm = ContextCompat.getDrawable(getContext(), id);
            species.setCompoundDrawablesWithIntrinsicBounds(hmm, null, null, null);

        }

        return convertView;
    }
}
