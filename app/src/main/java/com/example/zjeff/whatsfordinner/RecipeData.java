package com.example.zjeff.whatsfordinner;

import android.graphics.drawable.Drawable;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class RecipeData implements Serializable{
    private String name;
    private ArrayList<Ingredient> ingredients;
    private String description;
    private Drawable img;
    private Integer calories = 0;
    private Integer carbohydrates = 0;
    private Integer sugars = 0;
    private Integer vitamins = 0;
    private Integer minerals = 0;

    public RecipeData(String name, ArrayList<Ingredient> ingredients, String description) {
        this.ingredients = ingredients;
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIngredients(ArrayList<Ingredient> newIngredients){
        this.ingredients = newIngredients;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public void setDescription(String newDescription){
        this.description = newDescription;
    }

    public Drawable getImg(){
        return img;
    }

    public void setMinerals(int set){
        minerals = set;
    }
    public void setCalories(int set){
        calories = set;
    }

    public void setSugars(int set){
        sugars = set;
    }

    public void setCarbohydrates(int set){
        carbohydrates = set;
    }

    public void setVitamins(int set){
        vitamins = set;
    }

    public int getMinerals(){
        return minerals;
    }
    public int getCalories(){
        return calories;
    }
    public int getCarbohydrates(){
        return carbohydrates;
    }
    public int getVitamins(){
        return vitamins;
    }
    public int getSugars(){
        return sugars;
    }


}
