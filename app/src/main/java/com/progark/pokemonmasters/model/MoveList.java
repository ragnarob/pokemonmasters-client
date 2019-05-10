package com.progark.pokemonmasters.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MoveList {

    @SerializedName("moves")
    @Expose
    private List<Move> moves = null;

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

}