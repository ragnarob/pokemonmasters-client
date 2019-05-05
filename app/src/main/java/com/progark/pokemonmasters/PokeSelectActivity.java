package com.progark.pokemonmasters;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonList;
import com.progark.pokemonmasters.util.Data;
import com.progark.pokemonmasters.util.PokeListAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokeSelectActivity extends AppCompatActivity {


    private Data pokemonGetter = new Data();
    private PokemonList pokeList = new PokemonList();
    private List<Pokemon> viewPokemon = new ArrayList<Pokemon>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_select);

        PokeListAdapter adapter = new PokeListAdapter(this, viewPokemon);
        pokemonGetter.getData(adapter);


        ListView listView = findViewById(R.id.pokeList);
        listView.setAdapter(adapter);

    }

    public void printArray(View view) {
        Log.i("PokeSelect", pokeList.toString());
    }

}
