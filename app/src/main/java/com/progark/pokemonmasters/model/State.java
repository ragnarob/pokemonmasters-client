package com.progark.pokemonmasters.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class State {

    @SerializedName("round")
    @Expose
    private Integer round;
    @SerializedName("winner")
    @Expose
    private Object winner;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("gameState")
    @Expose
    private List<GameState> gameState = null;
    @SerializedName("actions")
    @Expose
    private List<Object> actions = null;

    public Integer getRound() {
        return round;
    }

    public void setRound(Integer round) {
        this.round = round;
    }

    public Object getWinner() {
        return winner;
    }

    public void setWinner(Object winner) {
        this.winner = winner;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<GameState> getGameState() {
        return gameState;
    }

    public void setGameState(List<GameState> gameState) {
        this.gameState = gameState;
    }

    public List<Object> getActions() {
        return actions;
    }

    public void setActions(List<Object> actions) {
        this.actions = actions;
    }

}