package com.example.zjeff.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditRecipe extends AppCompatActivity {

    public int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);

    }

    public void setPosition(int pos){
        position = pos;
    }

    public void editRecipe(View view){

    }
}
