package com.progark.pokemonmasters.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("species")
    @Expose
    private String species;
    @SerializedName("types")
    @Expose
    private List<String> types = null;
    @SerializedName("baseStats")
    @Expose
    private BaseStats baseStats;
    @SerializedName("abilities")
    @Expose
    private Abilities abilities;
    @SerializedName("moves")
    @Expose
    private List<String> moves = null;
    @SerializedName("detailedMoves")
    @Expose
    private List<DetailedMove> detailedMoves = null;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public void setBaseStats(BaseStats baseStats) {
        this.baseStats = baseStats;
    }

    public Abilities getAbilities() {
        return abilities;
    }

    public void setAbilities(Abilities abilities) {
        this.abilities = abilities;
    }

    public List<String> getMoves() {
        return moves;
    }

    public void setMoves(List<String> moves) {
        this.moves = moves;
    }

    public List<DetailedMove> getDetailedMoves() {
        return detailedMoves;
    }

    public void setDetailedMoves(List<DetailedMove> detailedMoves) {
        this.detailedMoves = detailedMoves;
    }

}