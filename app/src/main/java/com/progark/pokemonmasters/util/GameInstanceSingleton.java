package com.progark.pokemonmasters.util;

import com.progark.pokemonmasters.model.GameInstance;

public class GameInstanceSingleton {

    private static final GameInstanceSingleton ourInstance = new GameInstanceSingleton();

    public static GameInstanceSingleton getInstance() {
        return ourInstance;
    }

    private GameInstance gameInstance;
    private String playerName;

    private GameInstanceSingleton() {
        gameInstance = new GameInstance();
    }

    public GameInstance getGameInstance() {
        return gameInstance;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
