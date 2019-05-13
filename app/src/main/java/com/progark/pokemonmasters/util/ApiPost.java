package com.progark.pokemonmasters.util;

import java.util.List;

public class ApiPost {

    private String playerName;
    private String gameToken;
    private String gameCode;
    private String type;
    private String move;
    private int swap;
    private List<BattleReadyPokemon> pokemonList;

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getGameToken() {
        return gameToken;
    }

    public void setGameToken(String gameToken) {
        this.gameToken = gameToken;
    }

    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getSwap() {
        return swap;
    }

    public void setSwap(int swap) {
        this.swap = swap;
    }

    public List<BattleReadyPokemon> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<BattleReadyPokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }
}
