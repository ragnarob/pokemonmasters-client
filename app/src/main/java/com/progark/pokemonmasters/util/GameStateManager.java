package com.progark.pokemonmasters.util;

import com.progark.pokemonmasters.model.DetailedMove;
import com.progark.pokemonmasters.model.Pokemon;

import java.util.ArrayList;
import java.util.Stack;

public class GameStateManager {

    private Boolean ready;
    private String message;
    private String winner = null;

    private String playerName;
    private Pokemon pokemon;



    public Boolean getReady() {
        return ready;
    }

    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
}