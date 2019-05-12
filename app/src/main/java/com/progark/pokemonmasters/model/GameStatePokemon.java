package com.progark.pokemonmasters.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GameStatePokemon {

    @SerializedName("types")
    @Expose
    private List<String> types = null;
    @SerializedName("statusEffect")
    @Expose
    private List<Object> statusEffect = null;
    @SerializedName("moves")
    @Expose
    private List<String> moves = null;
    @SerializedName("alive")
    @Expose
    private Boolean alive;
    @SerializedName("immunityTurns")
    @Expose
    private Integer immunityTurns;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("baseStats")
    @Expose
    private BaseStats baseStats;
    @SerializedName("stats")
    @Expose
    private Stats stats;
    @SerializedName("positionInParty")
    @Expose
    private Integer positionInParty;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<Object> getStatusEffect() {
        return statusEffect;
    }

    public void setStatusEffect(List<Object> statusEffect) {
        this.statusEffect = statusEffect;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public Boolean getAlive() {
        return alive;
    }

    public void setAlive(Boolean alive) {
        this.alive = alive;
    }

    public Integer getImmunityTurns() {
        return immunityTurns;
    }

    public void setImmunityTurns(Integer immunityTurns) {
        this.immunityTurns = immunityTurns;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(BaseStats baseStats) {
        this.baseStats = baseStats;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Integer getPositionInParty() {
        return positionInParty;
    }

    public void setPositionInParty(Integer positionInParty) {
        this.positionInParty = positionInParty;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}
