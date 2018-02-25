package com.example.zjeff.whatsfordinner;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void newRecipe(View view){
        Intent intent = new Intent(this, NewRecipe.class);
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
        startActivity(intent);
    }
}
