package com.progark.pokemonmasters.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BaseStats {

    @SerializedName("hp")
    @Expose
    private Integer hp;
    @SerializedName("atk")
    @Expose
    private Integer atk;
    @SerializedName("def")
    @Expose
    private Integer def;
    @SerializedName("spa")
    @Expose
    private Integer spa;
    @SerializedName("spd")
    @Expose
    private Integer spd;
    @SerializedName("spe")
    @Expose
    private Integer spe;

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getAtk() {
        return atk;
    }

    public void setAtk(Integer atk) {
        this.atk = atk;
    }

    public Integer getDef() {
        return def;
    }

    public void setDef(Integer def) {
        this.def = def;
    }

    public Integer getSpa() {
        return spa;
    }

    public void setSpa(Integer spa) {
        this.spa = spa;
    }

    public Integer getSpd() {
        return spd;
    }

    public void setSpd(Integer spd) {
        this.spd = spd;
    }

    public Integer getSpe() {
        return spe;
    }

    public void setSpe(Integer spe) {
        this.spe = spe;
    }

}