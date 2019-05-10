package com.progark.pokemonmasters.util;

import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonList;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {

    @GET("pokemon")
    Single<PokemonList> getPokemon();

    @GET("pokemon/{pokemon_id}")
    Single<Pokemon> getSinglePokemon(@Path("pokemon_id") int pokemonId);

}
