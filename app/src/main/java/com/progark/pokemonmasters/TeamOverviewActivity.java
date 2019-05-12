package com.progark.pokemonmasters;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.progark.pokemonmasters.databinding.ItemTeamListBinding;
import com.progark.pokemonmasters.util.PokemonTeam;
import com.progark.pokemonmasters.util.TeamList;
import com.progark.pokemonmasters.util.TeamListAdapter;

public class TeamOverviewActivity extends AppCompatActivity {

    private TeamListAdapter adapter;
    private TeamList teamList = TeamList.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_overview);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

            adapter = new TeamListAdapter(this, teamList);

        ListView listView = findViewById(R.id.pokeTeams);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(TeamOverviewActivity.this, TeamActivity.class);
                intent.putExtra("teamIndex", i);
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.notifyDataSetChanged();
    }


    public void createTeam(View view) {
        TeamList.getInstance().add(new PokemonTeam(0));
        Intent intent = new Intent(this, PokeSelectActivity.class);
        startActivity(intent);
    }

}
