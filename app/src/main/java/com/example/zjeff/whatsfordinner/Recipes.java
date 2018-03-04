package com.example.zjeff.whatsfordinner;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Recipes extends AppCompatActivity {

    public String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        TextView textView = (TextView) findViewById(R.id.RecipeTest);

        Bundle bundle = getIntent().getExtras();
        String value = bundle.getString("recipeName");
        //Bundle bundle = getIntent().getExtras();
        //String name = bundle.getString("recipeName");
        //name = intent.getStringExtra("recipeName");
        textView.setText(value);
        /*FileInputStream ifile = null;
        ObjectInputStream in = null;
        RecipeData data = null;
        try{
            ifile = new FileInputStream("hamburgerRecipe.dat");
            in = new ObjectInputStream(ifile);
            data = (RecipeData)in.readObject();
            in.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }
        TextView textView = (TextView) findViewById(R.id.RecipeTest);
        String name = data.getName();
        textView.setText(name);*/
    }
}
