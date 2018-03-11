package com.example.zjeff.whatsfordinner;

import java.io.Serializable;

/**
 * Created by zjeff on 3/10/2018.
 */

public class Ingredient implements Serializable{
    private String name;
    private double amount;
    private String unit;

    public Ingredient(String name, double amount, String unit){
        this.name = name;
        this.amount = amount;
        this.unit = unit;
    }

    public String getName(){
        return name;
    }

    public double getAmount(){
        return amount;
    }

    public String getUnit(){
        return unit;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setAmount(double newAmount){
        amount = newAmount;
    }

    public void setUnit(String newUnit){
        unit = newUnit;
    }

    public String getRecipeStringDisplay(){
        String display = name + " ( " + amount + " " + unit.toString() + " )";
        return display;
    }
}
