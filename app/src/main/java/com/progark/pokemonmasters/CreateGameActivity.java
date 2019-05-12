package com.progark.pokemonmasters;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.progark.pokemonmasters.databinding.ActivityCreateGameBinding;
import com.progark.pokemonmasters.util.ApiPost;
import com.progark.pokemonmasters.util.Data;
import com.progark.pokemonmasters.util.GameInstanceSingleton;

public class CreateGameActivity extends AppCompatActivity {

    private String playerName;
    private EditText nameInput;
    private Data postData = new Data();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCreateGameBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_create_game);
        binding.setGameInstance(GameInstanceSingleton.getInstance().getGameInstance());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        nameInput = findViewById(R.id.nameInput);


    }

    public void confirmName(View view) {
        playerName = nameInput.getText().toString();
        nameInput.setVisibility(View.GONE);
        TextInputLayout nameLayout = findViewById(R.id.textInputLayout);
        nameLayout.setVisibility(View.GONE);
        Button confirmButton = findViewById(R.id.confirmButton);
        confirmButton.setVisibility(View.GONE);
        ApiPost apiPost = new ApiPost();
        apiPost.setPlayerName(playerName);
        postData.createGame(apiPost);

    }
}
