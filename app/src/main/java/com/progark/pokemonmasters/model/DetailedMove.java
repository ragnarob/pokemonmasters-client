package com.progark.pokemonmasters.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailedMove {

    @SerializedName("num")
    @Expose
    private Integer num;
    @SerializedName("accuracy")
    @Expose
    private Integer accuracy;
    @SerializedName("basePower")
    @Expose
    private Integer basePower;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("desc")
    @Expose
    private String desc;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pp")
    @Expose
    private Integer pp;
    @SerializedName("type")
    @Expose
    private String type;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(Integer accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getBasePower() {
        return basePower;
    }

    public void setBasePower(Integer basePower) {
        this.basePower = basePower;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
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

    public Integer getPp() {
        return pp;
    }

    public void setPp(Integer pp) {
        this.pp = pp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}