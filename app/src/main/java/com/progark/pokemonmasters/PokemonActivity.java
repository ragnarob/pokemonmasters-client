package com.progark.pokemonmasters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.util.Data;
import com.progark.pokemonmasters.util.PokeListAdapter;

public class PokemonActivity extends AppCompatActivity {

    private Data pokemonGetter = new Data();
    private Pokemon pokemon;
    private Intent intent = getIntent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon);
        pokemonGetter.getPokemon(intent.getIntExtra("pokeId", 151));
    }
}
