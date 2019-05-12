package com.progark.pokemonmasters.util;

import com.progark.pokemonmasters.model.Pokemon;

import java.util.ArrayList;
import java.util.List;


public class PokemonTeam {

    private List<BattleReadyPokemon> team = new ArrayList<>();
    private String name;

    public PokemonTeam(int cnt) {
        this.name = "Team "+cnt;
    }

    public List<BattleReadyPokemon> getTeam() {
        return team;
    }

    public void addPokemon(BattleReadyPokemon pokemon) {
        if (team.size() > 3) {
        }
        else {
            team.add(pokemon);
        }
    }

    public void removePokemon(BattleReadyPokemon pokemon) {
        team.remove(pokemon);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return team.toString();
    }

    public BattleReadyPokemon getPokemon(int index){
        return team.get(index);
    }

}
