package com.progark.pokemonmasters.util;

import java.util.ArrayList;

public class BattleReadyPokemonList extends ArrayList<BattleReadyPokemon> {

    private String species;
    private String[] moves;

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String[] getMoves() {
        return moves;
    }

    public void setMoves(String[] moves) {
        this.moves = moves;
    }
}
