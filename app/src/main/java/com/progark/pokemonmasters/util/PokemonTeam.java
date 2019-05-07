package com.progark.pokemonmasters.util;

import com.progark.pokemonmasters.model.Pokemon;
import java.util.List;

public class PokemonTeam {

    private List<Pokemon> team;

    public List<Pokemon> getTeam() {
        return team;
    }

    public void addPokemon(Pokemon pokemon) {
        team.add(pokemon);
    }

    public void removePokemon(Pokemon pokemon) {
        team.remove(pokemon);
    }

}
