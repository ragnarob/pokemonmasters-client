package com.progark.pokemonmasters.util;

import java.util.List;

public class BattleReadyPokemon {

    private String species;
    private List<String> moves;
    private int id;
    private String name;

    public BattleReadyPokemon(String species, List<String> moves, int id) {
        this.species = species;
        this.moves = moves;
        this.id = id;
        this.name = species;

    }

    public String getSpecies() {
        return this.species;
    }

    public List<String> getMoves() {
        return moves;
    }

    public int getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "BattleReadyPokemon{" +
                "species='" + species + '\'' +
                ", moves=" + moves +
                '}';
    }

    public String getName() {
        return name;
    }
}
