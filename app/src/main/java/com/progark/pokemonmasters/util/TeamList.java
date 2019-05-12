package com.progark.pokemonmasters.util;

import java.util.ArrayList;

public class TeamList extends ArrayList<PokemonTeam> {

    private static final TeamList ourInstance = new TeamList();
    private int battleTeamIndex;

    private TeamList(){}

    public static TeamList getInstance() {
        return ourInstance;
    }

    @Override
    public boolean add(PokemonTeam pokemonTeam) {
        return super.add(new PokemonTeam(super.size()+1));
    }

    public PokemonTeam getActiveTeam() {
        return super.get(super.size()-1);
    }

    public void setBattleTeam(int index){
        this.battleTeamIndex = index;
    }

    public PokemonTeam getBattleTeam(){
        return this.get(battleTeamIndex);
    }

}