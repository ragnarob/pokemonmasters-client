package com.progark.pokemonmasters.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import com.android.databinding.library.baseAdapters.BR;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameInstance extends BaseObservable {

    @SerializedName("state")
    @Expose
    private State state;
    @SerializedName("playerNames")
    @Expose
    private List<String> playerNames = null;
    @SerializedName("gameStage")
    @Expose
    private Integer gameStage;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("gameCode")
    @Expose
    private String gameCode;
    @SerializedName("gameToken")
    @Expose
    private String gameToken;
    @SerializedName("__v")
    @Expose
    private Integer v;

    @Bindable
    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Bindable
    public List<String> getPlayerNames() {
        return playerNames;
    }

    public void setPlayerNames(List<String> playerNames) {
        this.playerNames = playerNames;
    }

    @Bindable
    public Integer getGameStage() {
        return gameStage;
    }

    public void setGameStage(Integer gameStage) {
        this.gameStage = gameStage;
        notifyPropertyChanged(BR.gameStage);
    }

    @Bindable
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
        notifyPropertyChanged(BR.id);
    }

    @Bindable
    public String getGameCode() {
        return gameCode;
    }

    public void setGameCode(String gameCode) {
        this.gameCode = gameCode;
        notifyPropertyChanged(BR.gameCode);
    }

    @Bindable
    public String getGameToken() {
        return gameToken;
    }

    public void setGameToken(String gameToken) {
        this.gameToken = gameToken;
        notifyPropertyChanged(BR.gameToken);
    }

    @Bindable
    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
        notifyPropertyChanged(BR.v);
    }

}