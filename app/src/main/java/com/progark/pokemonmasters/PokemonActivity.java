package com.progark.pokemonmasters;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.progark.pokemonmasters.databinding.ActivityPokemonBinding;
import com.progark.pokemonmasters.model.BaseStatsDataModel;
import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonDataModel;
import com.progark.pokemonmasters.util.BattleReadyPokemon;
import com.progark.pokemonmasters.util.PokeSingleton;
import com.progark.pokemonmasters.util.TeamList;

import java.util.ArrayList;
import java.util.List;

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

        Button addToTeam = (Button) findViewById(R.id.addTeam);

        Intent intent = getIntent();
        pokemon = PokeSingleton.getInstance().getSinglePokemon(intent.getIntExtra("pokeId", 150));

        BaseStatsDataModel baseStatsDataModel = new BaseStatsDataModel(pokemon.getBaseStats().getHp(), pokemon.getBaseStats().getAtk(), pokemon.getBaseStats().getDef(), pokemon.getBaseStats().getSpa(), pokemon.getBaseStats().getSpd(), pokemon.getBaseStats().getSpe());
        final PokemonDataModel pokeModel = new PokemonDataModel(pokemon.getSpecies(), loadDrawable(this, pokemon.getNum().toString()), pokemon.getTypes(), baseStatsDataModel, pokemon.getAbilities());
        activityPokemonBinding.setPokemon(pokeModel);

        ArrayAdapter<String> typesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pokemon.getTypes());
        ListView types = findViewById(R.id.types);
        types.setAdapter(typesAdapter);

        final ListView moveListView = (ListView) findViewById(R.id.moves);
        ArrayAdapter<String> movesAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, pokemon.getMoves());
        moveListView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        moveListView.setAdapter(movesAdapter);

        addToTeam.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View view) {

                String msg = "Please select four moves";
                List<String> pokeMoves = new ArrayList<>();

                int cntChoice = moveListView.getCount();
                SparseBooleanArray sparseBooleanArray = moveListView.getCheckedItemPositions();
                for (int i = 0; i < cntChoice; i++) {
                    if (sparseBooleanArray.get(i)) {
                        pokeMoves.add(moveListView.getItemAtPosition(i).toString());
                    }
            }

                if (pokeMoves.size() != 4) {
                    Snackbar.make(findViewById(R.id.pokeActivityLayout),
                            msg,
                            Snackbar.LENGTH_LONG).show();
                } else {
                    BattleReadyPokemon battleReadyPokemon = new BattleReadyPokemon(pokemon.getSpecies(), pokeMoves, pokemon.getNum());
                    TeamList.getInstance().getActiveTeam().addPokemon(battleReadyPokemon);
                    finish();
                }
        }});

    }

    public Drawable loadDrawable(Context context, String pokeId) {
        int resourceId = getResources().getIdentifier("p" + pokeId, "drawable", "com.progark.pokemonmasters");
        return context.getDrawable(resourceId);
    }
}
