package com.progark.pokemonmasters.util;

public class TeamSingleton {

    private static final TeamSingleton ourInstance = new TeamSingleton();

    public static TeamSingleton getInstance() { return ourInstance; }

    private final TeamList teamList = new TeamList();

    public TeamList getTeamList() {
        return teamList;
    }
}
