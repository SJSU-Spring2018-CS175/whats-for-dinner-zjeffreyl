package com.example.zjeff.whatsfordinner;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<RecipeData> recipeDataBase;
    public static ArrayList<String> ingredientsDataBase;
    public File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recipeDataBase = new ArrayList<RecipeData>();
        ingredientsDataBase = new ArrayList<String>();
        file = new File(getFilesDir(), "recipeFile");
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<RecipeData> savedRecipeList = (ArrayList<RecipeData>) objectInputStream.readObject();
            ArrayList<String> savedIngredientsList = (ArrayList<String>) objectInputStream.readObject();
            objectInputStream.close();
            recipeDataBase.clear();
            for(int i = 0 ; i < savedRecipeList.size(); i ++){
                recipeDataBase.add(savedRecipeList.get(i));
            }
            ingredientsDataBase.clear();
            for(int i = 0 ; i < savedIngredientsList.size(); i ++){
                ingredientsDataBase.add(savedIngredientsList.get(i));
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public void newRecipe(View view){
        Intent intent = new Intent(this, NewRecipe.class);
        intent.putExtra("savedRecipes", recipeDataBase);
        intent.putExtra("savedIngredients", ingredientsDataBase);
        startActivity(intent);
    }

    public void meals(View view){
        Intent intent = new Intent(this, Meals.class);
        startActivity(intent);
    }

    public void groceries(View view){
        Intent intent = new Intent(this, Groceries.class);
        startActivity(intent);
    }

    public void recipes(View view){
        Intent intent = new Intent(this,Recipes.class);
        intent.putExtra("savedRecipes", recipeDataBase);
        intent.putExtra("savedIngredients", ingredientsDataBase);
        startActivity(intent);
    }
}
