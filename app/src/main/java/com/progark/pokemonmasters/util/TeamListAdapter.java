package com.progark.pokemonmasters.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.progark.pokemonmasters.R;


public class TeamListAdapter extends ArrayAdapter<PokemonTeam> {

    public TeamListAdapter(Context context, TeamList pokemonTeam) {
        super(context, 0, pokemonTeam);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        PokemonTeam pokemonTeam = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_team_list, parent, false);
        }

        String teamName = pokemonTeam.getName();
        TextView textView = convertView.findViewById(R.id.teamName);
        textView.setText(teamName);

        return convertView;
    }
}
