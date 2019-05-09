package com.progark.pokemonmasters.util;

import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonList;
import java.util.List;
import android.databinding.ObservableBoolean;

public class PokeSingleton {
    private static final PokeSingleton ourInstance = new PokeSingleton();

    public static PokeSingleton getInstance() {
        return ourInstance;
    }

    private final PokemonList pokemon = new PokemonList();
    private final ObservableBoolean pokeBoolean = new ObservableBoolean();

    private PokeSingleton() {
        Data pokeGetter = new Data();
        pokeGetter.getPokeList(pokemon);

    }

    public List<Pokemon> getPokemon() {
        return pokemon.getPokemon();
    }

    public Pokemon getSinglePokemon(int id) {
        return pokemon.getAPokemon(id - 1);
    }
}
