package com.example.zjeff.whatsfordinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Recipes extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);

        TextView textView = (TextView) findViewById(R.id.RecipeTest);
        Bundle bundle = getIntent().getExtras();
        String name = bundle.getString("recipeName");
        textView.setText(name);
    }
}
