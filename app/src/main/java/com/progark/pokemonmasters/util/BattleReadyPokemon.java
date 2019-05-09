package com.progark.pokemonmasters.util;

import java.util.List;

public class BattleReadyPokemon {

    private String id;
    private List<String> moves;

    public BattleReadyPokemon(String id, List<String> moves) {
        this.id = id;
        this.moves = moves;
    }

    public String getId() {
        return id;
    }

    public List<String> getMoves() {
        return moves;
    }

    @Override
    public String toString() {
        return "BattleReadyPokemon{" +
                "id='" + id + '\'' +
                ", moves=" + moves +
                '}';
    }
}
