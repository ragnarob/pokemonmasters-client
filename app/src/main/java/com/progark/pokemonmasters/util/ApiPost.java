package com.progark.pokemonmasters.util;

public class ApiPost {

    private String playerName;
    private String gameToken;
    private String gameCode;
    private String type;
    private int swap;
    private BattleReadyPokemonList pokemonList;

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

    public BattleReadyPokemonList getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(BattleReadyPokemonList pokemonList) {
        this.pokemonList = pokemonList;
    }
}
