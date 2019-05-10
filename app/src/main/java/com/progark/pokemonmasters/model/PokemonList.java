package com.progark.pokemonmasters.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PokemonList {

    @SerializedName("pokemon")
    @Expose
    private List<Pokemon> pokemon = null;

    public List<Pokemon> getPokemon() { return pokemon; }

    public void setPokemon(PokemonList pokemon) {
        this.pokemon = pokemon.getPokemon();
    }

    public int size() {
        return pokemon.size();
    }

    public Pokemon getAPokemon(int position) {
        return pokemon.get(position);
    }

    public long getPokemonId(int position) {
        return getAPokemon(position).getNum();
    }


    @Override
    public String toString() {
        String result = "-";
        for(Pokemon p: pokemon) {
            result += p.toString() + "\n";
        }
        result += pokemon.size();
        return result;
    }
}