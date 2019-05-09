package com.progark.pokemonmasters.model;

import android.graphics.drawable.Drawable;

import java.util.List;

public class PokemonDataModel {

    private final String species;
    private final Drawable thumbnail;
    private final List<String> types;
    private final BaseStatsDataModel baseStats;
    private final Abilities abilities;

    public PokemonDataModel(String species, Drawable thumbnail, List<String> types, BaseStatsDataModel baseStats, Abilities abilities) {
        this.species = species;
        this.thumbnail = thumbnail;
        this.types = types;
        this.baseStats = baseStats;
        this.abilities = abilities;
    }

    public String getSpecies() {
        return species;
    }

    public Drawable getThumbnail() {
        return thumbnail;
    }

    public List<String> getTypes() {
        return types;
    }

    public BaseStatsDataModel getBaseStats() {
        return baseStats;
    }

    public Abilities getAbilities() {
        return abilities;
    }
}
