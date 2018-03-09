package com.example.zjeff.whatsfordinner;

import android.graphics.drawable.Drawable;

import java.io.FileOutputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class RecipeData implements Serializable{
    private String name;
    private ArrayList<String> ingredients;
    private String description;
    private Drawable img;

    public RecipeData(String name, ArrayList<String> ingredients, String description) {
        this.ingredients = ingredients;
        this.name = name;
        this.description = description;
        this.img = img;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setIngredients(ArrayList<String> newIngredients){
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
}
