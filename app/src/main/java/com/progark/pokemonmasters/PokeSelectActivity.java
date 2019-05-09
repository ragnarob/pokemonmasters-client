package com.progark.pokemonmasters;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.util.PokeListAdapter;
import com.progark.pokemonmasters.util.PokeSingleton;

import java.util.ArrayList;
import java.util.List;

public class PokeSelectActivity extends AppCompatActivity {


    private List<Pokemon> viewPokemon = new ArrayList<Pokemon>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poke_select);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);

        final PokeListAdapter adapter = new PokeListAdapter(this, viewPokemon);

        adapter.addAll(PokeSingleton.getInstance().getPokemon());

        ListView listView = findViewById(R.id.pokemonListView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Pokemon pokemon = adapter.getItem(i);

                Intent intent = new Intent(PokeSelectActivity.this, PokemonActivity.class);
                intent.putExtra("pokeId", pokemon.getNum());
                startActivity(intent);
            }
        });

    }

}
