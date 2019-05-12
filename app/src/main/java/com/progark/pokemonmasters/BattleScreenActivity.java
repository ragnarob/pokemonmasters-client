package com.progark.pokemonmasters;

import android.content.Intent;
import android.databinding.Observable;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.progark.pokemonmasters.model.GameInstance;
import com.progark.pokemonmasters.model.GameState;
import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.util.ApiPost;
import com.progark.pokemonmasters.util.BattleReadyPokemon;
import com.progark.pokemonmasters.util.BattleReadyPokemonListAdapter;
import com.progark.pokemonmasters.util.Data;
import com.progark.pokemonmasters.util.GameInstanceSingleton;
import com.progark.pokemonmasters.util.PokeListAdapter;
import com.progark.pokemonmasters.util.PokeSingleton;
import com.progark.pokemonmasters.util.PokemonTeam;
import com.progark.pokemonmasters.util.TeamList;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class BattleScreenActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private BattleReadyPokemon myPokemon;
    private Data postData = new Data();
    private ApiPost apiPost = new ApiPost();
    private GameInstanceSingleton gameInstanceSingleton = GameInstanceSingleton.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_screen);
        listenForOpPokemonChange(gameInstanceSingleton.getGameInstance());

        mediaPlayer = MediaPlayer.create(this, R.raw.pokemusic);
        mediaPlayer.start();


        PokemonTeam myPokeTeam = TeamList.getInstance().getBattleTeam();
        myPokemon = myPokeTeam.getPokemon(0);

        updatePokemonViews();

        final BattleReadyPokemonListAdapter adapter = new BattleReadyPokemonListAdapter(this, myPokeTeam.getTeam());

        ListView listView = findViewById(R.id.pokeTeamList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BattleReadyPokemon pokemon = adapter.getItem(i);
                myPokemon = pokemon;
                View pokeTeamList = findViewById(R.id.pokeTeamList);
                pokeTeamList.setVisibility(View.GONE);
                updatePokemonViews();
                View fightButton = findViewById(R.id.FightButton);
                fightButton.setVisibility(View.VISIBLE);
                View pokemonButton = findViewById(R.id.PokemonButton);
                pokemonButton.setVisibility(View.VISIBLE);
            }
        });

//        apiPost.setPlayerName(GameInstanceSingleton.getInstance().getPlayerName());
//        apiPost.setGameToken(GameInstanceSingleton.getInstance().getGameInstance().getGameToken());
//        apiPost.setPokemonList(TeamList.getInstance().getBattleTeam().getTeam());
//        postData.createTeam(apiPost);

//        apiPost.setGameCode(gameInstanceSingleton.getGameInstance().getGameCode());
//        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
//        postData.getGameStatus(apiPost);
    }

    public void updatePokemonViews(){
        String pokeSpecies = myPokemon.getSpecies();
        String myPokeNum = "b" + myPokemon.getId();
        TextView myPokemonName = (TextView) findViewById(R.id.myPokemonName);
        myPokemonName.setText(pokeSpecies);

        GifImageView myPokemonView = (GifImageView) findViewById(R.id.myPokemon);

        try {
            GifDrawable sprite = new GifDrawable(getResources(), getResources().getIdentifier(myPokeNum, "drawable", "com.progark.pokemonmasters"));
            myPokemonView.setImageDrawable(sprite);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView myPokemonHealth = (TextView) findViewById(R.id.myHealth);
        String health = PokeSingleton.getInstance().getSinglePokemon(myPokemon.getId()).getBaseStats().getHp().toString();
        myPokemonHealth.setText(health+"/"+health+"HP");

        Button move1 = findViewById(R.id.move1);
        move1.setText(myPokemon.getMoves().get(0));

        Button move2 = findViewById(R.id.move2);
        move2.setText(myPokemon.getMoves().get(1));

        Button move3 = findViewById(R.id.move3);
        move3.setText(myPokemon.getMoves().get(2));

        Button move4 = findViewById(R.id.move4);
        move4.setText(myPokemon.getMoves().get(3));
    }

    public void choosePokemon(View view){
        View fightButton = findViewById(R.id.FightButton);
        fightButton.setVisibility(View.GONE);
        View pokemonButton = findViewById(R.id.PokemonButton);
        pokemonButton.setVisibility(View.GONE);
        View pokeTeamList = findViewById(R.id.pokeTeamList);
        pokeTeamList.setVisibility(View.VISIBLE);

    }

    public void chooseMove(View view){
        View fightButton = findViewById(R.id.FightButton);
        fightButton.setVisibility(View.GONE);
        View pokemonButton = findViewById(R.id.PokemonButton);
        pokemonButton.setVisibility(View.GONE);

        View move1 = findViewById(R.id.move1);
        move1.setVisibility(View.VISIBLE);
        View move2 = findViewById(R.id.move2);
        move2.setVisibility(View.VISIBLE);
        View move3 = findViewById(R.id.move3);
        move3.setVisibility(View.VISIBLE);
        View move4 = findViewById(R.id.move4);
        move4.setVisibility(View.VISIBLE);

    }

    public void move1(View view){
        apiPost.setGameCode(gameInstanceSingleton.getGameInstance().getGameCode());
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        postData.getGameStatus(apiPost);
        visibilityReset();
    }

    public void move2(View view){
        apiPost.setGameCode(gameInstanceSingleton.getGameInstance().getGameCode());
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        postData.getGameStatus(apiPost);
        visibilityReset();
    }

    public void move3(View view){
        apiPost.setGameCode(gameInstanceSingleton.getGameInstance().getGameCode());
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        postData.getGameStatus(apiPost);
        visibilityReset();
    }

    public void move4(View view){
        apiPost.setGameCode(gameInstanceSingleton.getGameInstance().getGameCode());
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        postData.getGameStatus(apiPost);
        visibilityReset();
    }

    public void visibilityReset(){
        View move1 = findViewById(R.id.move1);
        move1.setVisibility(View.GONE);
        View move2 = findViewById(R.id.move2);
        move2.setVisibility(View.GONE);
        View move3 = findViewById(R.id.move3);
        move3.setVisibility(View.GONE);
        View move4 = findViewById(R.id.move4);
        move4.setVisibility(View.GONE);

        View fightButton = findViewById(R.id.FightButton);
        fightButton.setVisibility(View.VISIBLE);
        View pokemonButton = findViewById(R.id.PokemonButton);
        pokemonButton.setVisibility(View.VISIBLE);
    }

    public void listenForOpPokemonChange(GameInstance gameInstance) {
        gameInstance.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.state) {
                    GameInstance gameInstance = (GameInstance) sender;
                    for (GameState gameState : gameInstance.getState().getGameState()) {
                        if (!(gameState.getPlayerName().equals(GameInstanceSingleton.getInstance().getPlayerName()))) {
                            String opponentPokemonName = gameState.getPokemon().get(0).getName();
                            String opponentPokemonId = "p" + gameState.getPokemon().get(0).getNum();
                            String opponentPokemonHealth = gameState.getPokemon().get(0).getStats().getHp();
                            String opponentPokemonMaxHealth = gameState.getPokemon().get(0).getBaseStats().getHp().toString();

                            TextView opponentName = findViewById(R.id.opponentPokemonName);
                            opponentName.setText(opponentPokemonName);
                            TextView opponentHealth = findViewById(R.id.opponentHealth);
                            opponentHealth.setText(opponentPokemonHealth+"/"+opponentPokemonMaxHealth+"HP");

                            GifImageView opponentPokemonView = findViewById(R.id.opponentPokemon);

                            try {
                                GifDrawable sprite = new GifDrawable(getResources(), getResources().getIdentifier(opponentPokemonId, "drawable", "com.progark.pokemonmasters"));
                                opponentPokemonView.setImageDrawable(sprite);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }

                }
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mediaPlayer.start();
    }


}
