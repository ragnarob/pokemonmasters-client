package com.progark.pokemonmasters.model;

public class BaseStatsDataModel {

    private Integer hp;
    private Integer atk;
    private Integer def;
    private Integer spa;
    private Integer spd;
    private Integer spe;

    public BaseStatsDataModel(Integer hp, Integer atk, Integer def, Integer spa, Integer spd, Integer spe) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spa = spa;
        this.spd = spd;
        this.spe = spe;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getAtk() {
        return atk;
    }

    public Integer getDef() {
        return def;
    }

    public Integer getSpa() {
        return spa;
    }

    public Integer getSpd() {
        return spd;
    }

    public Integer getSpe() {
        return spe;
    }
}
