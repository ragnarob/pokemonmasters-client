package com.progark.pokemonmasters;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.progark.pokemonmasters.util.TeamList;

public class TeamActivity extends AppCompatActivity {

    private int teamIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team);

        Intent intent = getIntent();
        teamIndex = intent.getIntExtra("teamIndex", 0);
    }

    public void makeActiveTeam(View view) {
        TeamList.getInstance().setBattleTeam(teamIndex);
        finish();
    }

    public void deleteTeam(View view) {
        TeamList.getInstance().remove(teamIndex);
        finish();
    }
}
