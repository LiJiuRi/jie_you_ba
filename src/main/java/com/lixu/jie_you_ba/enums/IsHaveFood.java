package com.lixu.jie_you_ba.enums;

/**
 * @Classname IsHaveFood
 * @Description TODO
 * @Date 2019-03-15 09:45
 * @Created by lixu
 */
public enum IsHaveFood {

    False(0,false,"没有子菜品"),
    True(1,true,"有子菜品");

    private int value;
    private boolean alias;
    private String desc;

    IsHaveFood(int value,boolean alias,String desc) {
        this.alias = alias;
        this.value = value;
        this.desc = desc;
    }

    public static IsHaveFood getByValue(int value) {
        IsHaveFood[] values = IsHaveFood.values();
        for(IsHaveFood isHaveFood : values) {
            if(isHaveFood.value == value) {
                return isHaveFood;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isAlias() {
        return alias;
    }

    public void setAlias(boolean alias) {
        this.alias = alias;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }}
