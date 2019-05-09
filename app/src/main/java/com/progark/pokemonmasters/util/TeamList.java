package com.progark.pokemonmasters.util;

import java.util.ArrayList;
import java.util.List;

public class TeamList {

    private List<PokemonTeam> teamList = new ArrayList<PokemonTeam>();

    public List<PokemonTeam> getTeamList() {
        return teamList;
    }

    public void addTeam(PokemonTeam pokemonTeam) {
        teamList.add(pokemonTeam);
    }

    public void deleteTeam(PokemonTeam pokemonTeam) {
        teamList.remove(pokemonTeam);
    }
}
