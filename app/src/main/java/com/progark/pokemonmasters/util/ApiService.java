package com.progark.pokemonmasters.util;

import com.progark.pokemonmasters.model.GameInstance;
import com.progark.pokemonmasters.model.GameState;
import com.progark.pokemonmasters.model.Pokemon;
import com.progark.pokemonmasters.model.PokemonList;
import com.progark.pokemonmasters.model.Status;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {

    @GET("pokemon")
    Single<PokemonList> getPokemon();

    @GET("pokemon/{pokemon_id}")
    Single<Pokemon> getSinglePokemon(@Path("pokemon_id") int pokemonId);

    @POST("creategame")
    Single<GameInstance> createGame(@Body ApiPost apiPost);

    @POST("joingame")
    Single<GameInstance> joinGame(@Body ApiPost apiPost);

    @POST("createteam")
    Single<Status> createTeam(@Body ApiPost apiPost);

    @POST("game/gamestatus")
    Single<GameInstance> getGameStatus(@Body ApiPost apiPost);

    @POST("game/action")
    Single<GameInstance> addAction(@Body ApiPost apiPost);


}
