package com.progark.pokemonmasters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.progark.pokemonmasters.databinding.ActivityPokemonBinding;
import com.progark.pokemonmasters.databinding.BaseStatsBinding;
import com.progark.pokemonmasters.model.BaseStats;
import com.progark.pokemonmasters.model.BaseStatsDataModel;
import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonDataModel;
import com.progark.pokemonmasters.util.PokeSingleton;

public class PokemonActivity extends AppCompatActivity {


    private Pokemon pokemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPokemonBinding activityPokemonBinding = DataBindingUtil.setContentView(this, R.layout.activity_pokemon);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        pokemon = PokeSingleton.getInstance().getSinglePokemon(intent.getIntExtra("pokeId", 150));

        BaseStatsDataModel baseStatsDataModel = new BaseStatsDataModel(pokemon.getBaseStats().getHp(), pokemon.getBaseStats().getAtk(), pokemon.getBaseStats().getDef(), pokemon.getBaseStats().getSpa(), pokemon.getBaseStats().getSpd(), pokemon.getBaseStats().getSpe());
        PokemonDataModel pokeModel = new PokemonDataModel(pokemon.getSpecies(), loadDrawable(this, pokemon.getNum().toString()), pokemon.getTypes(), baseStatsDataModel, pokemon.getAbilities());
        activityPokemonBinding.setPokemon(pokeModel);

        ArrayAdapter<String> typesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokemon.getTypes());
        ListView types = findViewById(R.id.types);
        types.setAdapter(typesAdapter);

    }

    public Drawable loadDrawable(Context context, String pokeId) {
        int resourceId = getResources().getIdentifier("p" + pokeId, "drawable", "com.progark.pokemonmasters");
        return context.getDrawable(resourceId);
    }
}
