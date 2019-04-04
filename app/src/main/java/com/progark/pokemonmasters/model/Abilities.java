package com.progark.pokemonmasters.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Abilities {

    @SerializedName("0")
    @Expose
    private String _0;
    @SerializedName("H")
    @Expose
    private String h;

    public String get0() {
        return _0;
    }

    public void set0(String _0) {
        this._0 = _0;
    }

    public String getH() {
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }

}