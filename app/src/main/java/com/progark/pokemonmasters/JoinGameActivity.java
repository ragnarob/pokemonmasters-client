package com.progark.pokemonmasters;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.progark.pokemonmasters.util.ApiPost;
import com.progark.pokemonmasters.util.Data;
import com.progark.pokemonmasters.util.GameInstanceSingleton;
import com.progark.pokemonmasters.util.TeamList;

public class JoinGameActivity extends AppCompatActivity {

    private EditText nameInput;
    private EditText gameCodeInput;
    private Data postData = new Data();
    private ApiPost apiPost = new ApiPost();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_game);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        nameInput = findViewById(R.id.joinPlayerName);
        gameCodeInput = findViewById(R.id.joinGameCode);
    }

    public void confirmName(View view) {
        String playerName = nameInput.getText().toString();
        String gameCode = gameCodeInput.getText().toString();

        GameInstanceSingleton.getInstance().setPlayerName(playerName);
        GameInstanceSingleton.getInstance().getGameInstance().setGameCode(gameCode);

        apiPost.setPlayerName(playerName);
        apiPost.setGameCode(gameCode);

        postData.joinGame(apiPost, this);

        Intent intent = new Intent(this, BattleScreenActivity.class);
        startActivity(intent);
    }

    public void createTeam() {
        apiPost.setPokemonList(TeamList.getInstance().getBattleTeam().getTeam());
        apiPost.setGameToken(GameInstanceSingleton.getInstance().getGameInstance().getGameToken());
        postData.createTeam(apiPost);

    }
}
