package com.progark.pokemonmasters.util;

import java.util.List;

public class PokemonTeam {

    private List<BattleReadyPokemon> team;

    public List<BattleReadyPokemon> getTeam() {
        return team;
    }

    public void addPokemon(BattleReadyPokemon pokemon) {
        team.add(pokemon);
    }

    public void removePokemon(BattleReadyPokemon pokemon) {
        team.remove(pokemon);
    }

}
