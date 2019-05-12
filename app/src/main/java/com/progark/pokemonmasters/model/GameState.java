package com.progark.pokemonmasters.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameState {

    @SerializedName("pokemon")
    @Expose
    private List<Object> pokemon = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("playerName")
    @Expose
    private String playerName;

    public List<Object> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<Object> pokemon) {
        this.pokemon = pokemon;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

}
