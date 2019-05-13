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
import com.progark.pokemonmasters.model.GameStatePokemon;
import com.progark.pokemonmasters.util.ApiPost;
import com.progark.pokemonmasters.util.BattleReadyPokemon;
import com.progark.pokemonmasters.util.BattleReadyPokemonListAdapter;
import com.progark.pokemonmasters.util.Data;
import com.progark.pokemonmasters.util.GameInstanceSingleton;
import com.progark.pokemonmasters.util.PokemonTeam;
import com.progark.pokemonmasters.util.TeamList;

import java.io.IOException;

import pl.droidsonroids.gif.GifDrawable;
import pl.droidsonroids.gif.GifImageView;

public class BattleScreenActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private GameStatePokemon myPokemon;
    private Data postData = new Data();
    private ApiPost apiPost = new ApiPost();
    private GameInstanceSingleton gameInstanceSingleton = GameInstanceSingleton.getInstance();
    private String playerName = GameInstanceSingleton.getInstance().getPlayerName();
    private int roundNumber;
    private int prevRound;
    private Boolean gate = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_screen);
        listenForOpPokemonChange(gameInstanceSingleton.getGameInstance());

        mediaPlayer = MediaPlayer.create(this, R.raw.pokemusic);
        mediaPlayer.start();


        PokemonTeam myPokeTeam = TeamList.getInstance().getBattleTeam();
//        if (gameInstanceSingleton.getGameInstance().getState().getGameState().size() > 0) {
//            for (GameState gameState : gameInstanceSingleton.getGameInstance().getState().getGameState()) {
//                if (gameState.getPlayerName().equals(playerName)) {
//                    myPokemon = gameState.getPokemon().get(0);
//                    updatePokemonViews();
//                }
//
//            }
//        }

        final BattleReadyPokemonListAdapter adapter = new BattleReadyPokemonListAdapter(this, myPokeTeam.getTeam());

        ListView listView = findViewById(R.id.pokeTeamList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                BattleReadyPokemon pokemon = adapter.getItem(i);

                apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
                apiPost.setPlayerName(playerName);
                apiPost.setType("swap");
                apiPost.setSwap(i+1);
                postData.addAction(apiPost);

                View pokeTeamList = findViewById(R.id.pokeTeamList);
                pokeTeamList.setVisibility(View.GONE);
//                View fightButton = findViewById(R.id.FightButton);
//                fightButton.setVisibility(View.VISIBLE);
//                View pokemonButton = findViewById(R.id.PokemonButton);
//                pokemonButton.setVisibility(View.VISIBLE);
                visibilityLock();
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
        String pokeSpecies = myPokemon.getName();
        String myPokeNum = "b" + myPokemon.getNum();
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
        String health = myPokemon.getStats().getHp();
        String maxHealth = myPokemon.getBaseStats().getHp().toString();
        myPokemonHealth.setText(health+"/"+maxHealth+"HP");

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

        prevRound = roundNumber;


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

        prevRound = roundNumber;


    }

    public void move1(View view){
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        apiPost.setPlayerName(playerName);
        apiPost.setType("move");
        apiPost.setMove(myPokemon.getMoves().get(0));
        postData.addAction(apiPost);
        visibilityLock();
    }

    public void move2(View view){
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        apiPost.setPlayerName(playerName);
        apiPost.setType("move");
        apiPost.setMove(myPokemon.getMoves().get(1));
        postData.addAction(apiPost);
        visibilityLock();
    }

    public void move3(View view){
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        apiPost.setPlayerName(playerName);
        apiPost.setType("move");
        apiPost.setMove(myPokemon.getMoves().get(2));
        postData.addAction(apiPost);
        visibilityLock();
    }

    public void move4(View view){
        apiPost.setGameToken(gameInstanceSingleton.getGameInstance().getGameToken());
        apiPost.setPlayerName(playerName);
        apiPost.setType("move");
        apiPost.setMove(myPokemon.getMoves().get(3));
        postData.addAction(apiPost);
        visibilityLock();
    }

    public void visibilityLock(){
        View move1 = findViewById(R.id.move1);
        move1.setVisibility(View.GONE);
        View move2 = findViewById(R.id.move2);
        move2.setVisibility(View.GONE);
        View move3 = findViewById(R.id.move3);
        move3.setVisibility(View.GONE);
        View move4 = findViewById(R.id.move4);
        move4.setVisibility(View.GONE);

        prevRound = roundNumber;
    }

    public void visibilityUnlock() {
        if (!(prevRound == roundNumber)) {
            View fightButton = findViewById(R.id.FightButton);
            fightButton.setVisibility(View.VISIBLE);
            View pokemonButton = findViewById(R.id.PokemonButton);
            pokemonButton.setVisibility(View.VISIBLE);
        }
    }

    public void winner(String winner) {
        if (gate) {
            gate = false;
            Intent intent = new Intent(this, VictoryActivity.class);
            intent.putExtra("winner", winner);
            startActivity(intent);
        }
    }

    public void listenForOpPokemonChange(GameInstance gameInstance) {
        gameInstance.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                if (propertyId == BR.state) {
                    GameInstance gameInstance = (GameInstance) sender;
                    TextView messageView = findViewById(R.id.fightInfo);
                    messageView.setText(gameInstance.getState().getMessage());
                    roundNumber = gameInstance.getState().getRound();
                    visibilityUnlock();
                    if (gameInstance.getState().getWinner() != null) {
                        winner(gameInstance.getState().getWinner().toString());
                    }
                    for (GameState gameState : gameInstance.getState().getGameState()) {
                        if ((!(gameState.getPlayerName().equals(playerName)))&&(gameState.getPokemon().size() > 0)) {
                            for (GameStatePokemon pokemon : gameState.getPokemon()) {
                                if (pokemon.getPositionInParty() == 1) {
                                    String opponentPokemonName = pokemon.getName();
                                    String opponentPokemonId = "p" + pokemon.getNum();
                                    String opponentPokemonHealth = pokemon.getStats().getHp();
                                    String opponentPokemonMaxHealth = pokemon.getBaseStats().getHp().toString();

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
                        if ((gameState.getPlayerName().equals(playerName)) && gameState.getPokemon().size() > 0) {
                            for (GameStatePokemon pokemon : gameState.getPokemon())
                                if (pokemon.getPositionInParty() == 1) {
                                    myPokemon = pokemon;
                                    updatePokemonViews();
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
