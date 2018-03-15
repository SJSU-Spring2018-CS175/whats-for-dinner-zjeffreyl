package com.example.zjeff.whatsfordinner;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Recipes extends AppCompatActivity {

    public File file;
    public ArrayList<RecipeData> savedRecipes;
    public ArrayList<Ingredient> savedIngredients;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");
        //savedIngredients = (ArrayList<Ingredient>)bundle.getSerializable("savedIngredients");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        Configuration config = getResources().getConfiguration();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(config.orientation == Configuration.ORIENTATION_LANDSCAPE){
            LandscapeFragment landscapeFragment = new LandscapeFragment();
            fragmentTransaction.replace(android.R.id.content, landscapeFragment);
        }else{
            PortraitFragment portraitFragment = new PortraitFragment();
            fragmentTransaction.replace(android.R.id.content, portraitFragment);
        }
        fragmentTransaction.commit();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
