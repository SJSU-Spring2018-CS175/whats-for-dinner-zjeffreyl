package com.example.zjeff.whatsfordinner;

import java.util.ArrayList;

public class RecipeData {
    private String name;
    private ArrayList<String> ingredients;
    private String description;

    public RecipeData(String name, ArrayList<String> ingredients, String description){
        this.ingredients = ingredients;
        this.name = name;
        this.description = description;
    }

    public ArrayList<String> getIngredients(){
        return ingredients;
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }
}
