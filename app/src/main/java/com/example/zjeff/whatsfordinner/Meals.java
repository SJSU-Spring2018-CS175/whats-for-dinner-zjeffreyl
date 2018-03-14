package com.example.zjeff.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Meals extends AppCompatActivity{

    ArrayAdapter<String> adapter;
    Spinner breakfastSpinnerSunday;
    Spinner lunchSpinnerSunday;
    Spinner dinnerSpinnerSunday;
    Spinner breakfastSpinnerMonday;
    Spinner lunchSpinnerMonday;
    Spinner dinnerSpinnerMonday;
    Spinner breakfastSpinnerTuesday;
    Spinner lunchSpinnerTuesday;
    Spinner dinnerSpinnerTuesday;
    Spinner breakfastSpinnerWednesday;
    Spinner lunchSpinnerWednesday;
    Spinner dinnerSpinnerWednesday;
    Spinner breakfastSpinnerThursday;
    Spinner lunchSpinnerThursday;
    Spinner dinnerSpinnerThursday;
    Spinner breakfastSpinnerFriday;
    Spinner lunchSpinnerFriday;
    Spinner dinnerSpinnerFriday;
    Spinner breakfastSpinnerSaturday;
    Spinner lunchSpinnerSaturday;
    Spinner dinnerSpinnerSaturday;

    ArrayList<String> recipeOptionsName;
    ArrayList<RecipeData> recipeOptions;
    RecipeData eatingOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        recipeOptions = new ArrayList<RecipeData>();
        recipeOptionsName = new ArrayList<String>();
        ArrayList<Spinner> spinners = new ArrayList<>();
        eatingOut = new RecipeData("Eating Out", null, null);

        breakfastSpinnerSunday = (Spinner) findViewById(R.id.SundayBreakfastSpinner);
        lunchSpinnerSunday = (Spinner) findViewById(R.id.SundayLunchSpinner);
        dinnerSpinnerSunday = (Spinner) findViewById(R.id.SundayDinnerSpinner);
        breakfastSpinnerMonday = (Spinner) findViewById(R.id.MondayBreakfastSpinner);
        lunchSpinnerMonday = (Spinner) findViewById(R.id.MondayLunchSpinner);
        dinnerSpinnerMonday = (Spinner) findViewById(R.id.MondayDinnerSpinner);
        breakfastSpinnerTuesday = (Spinner) findViewById(R.id.TuesdayBreakfastSpinner);
        lunchSpinnerTuesday = (Spinner) findViewById(R.id.TuesdayLunchSpinner);
        dinnerSpinnerTuesday = (Spinner) findViewById(R.id.TuesdayDinnerSpinner);
        breakfastSpinnerWednesday = (Spinner) findViewById(R.id.WednesdayBreakfastSpinner);
        lunchSpinnerWednesday = (Spinner) findViewById(R.id.WednesdayLunchSpinner);
        dinnerSpinnerWednesday = (Spinner) findViewById(R.id.WednesdayDinnerSpinner);
        breakfastSpinnerThursday = (Spinner) findViewById(R.id.ThursdayBreakfastSpinner);
        lunchSpinnerThursday = (Spinner) findViewById(R.id.ThursdayLunchSpinner);
        dinnerSpinnerThursday = (Spinner) findViewById(R.id.ThursdayDinnerSpinner);
        breakfastSpinnerFriday = (Spinner) findViewById(R.id.FridayBreakfastSpinner);
        lunchSpinnerFriday = (Spinner) findViewById(R.id.FridayLunchSpinner);
        dinnerSpinnerFriday = (Spinner) findViewById(R.id.FridayDinnerSpinner);
        breakfastSpinnerSaturday = (Spinner) findViewById(R.id.SaturdayBreakfastSpinner);
        lunchSpinnerSaturday = (Spinner) findViewById(R.id.SaturdayLunchSpinner);
        dinnerSpinnerSaturday = (Spinner) findViewById(R.id.SaturdayDinnerSpinner);

        spinners.add(breakfastSpinnerSunday);
        spinners.add(lunchSpinnerSunday);
        spinners.add(dinnerSpinnerSunday);
        spinners.add(breakfastSpinnerMonday);
        spinners.add(lunchSpinnerMonday);
        spinners.add(dinnerSpinnerMonday);
        spinners.add(breakfastSpinnerTuesday);
        spinners.add(lunchSpinnerTuesday);
        spinners.add(dinnerSpinnerTuesday);
        spinners.add(breakfastSpinnerWednesday);
        spinners.add(lunchSpinnerWednesday);
        spinners.add(dinnerSpinnerWednesday);
        spinners.add(breakfastSpinnerThursday);
        spinners.add(lunchSpinnerThursday);
        spinners.add(dinnerSpinnerThursday);
        spinners.add(breakfastSpinnerFriday);
        spinners.add(lunchSpinnerFriday);
        spinners.add(dinnerSpinnerFriday);
        spinners.add(breakfastSpinnerSaturday);
        spinners.add(lunchSpinnerSaturday);
        spinners.add(dinnerSpinnerSaturday);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //Comes second time around
        if (!recipeOptions.contains(eatingOut)) {
                recipeOptions.add(eatingOut);
        }

        //getting the recipe object
        if(intent.hasExtra("selectedRecipeObjects")) {
            ArrayList<RecipeData> selectedRecipeObject = (ArrayList<RecipeData>) bundle.getSerializable("selectedRecipeObjects");
            //added one item to recipe
            recipeOptions.addAll(selectedRecipeObject);
            bundle.remove("selectedRecipeObjects");
        }
        for(int i = 0; i < recipeOptions.size(); i++){
            recipeOptionsName.add(recipeOptions.get(i).getName());
        }

        //adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_spinner_view, recipeOptions);
    /*}

    @Override
    protected void onResume() {
        super.onResume();*/
        adapter = new ArrayAdapter<String>(this, R.layout.custom_spinner_view, recipeOptionsName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        int counter =0;
        for(Spinner s: spinners){
            counter++;
            s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(!adapterView.getItemAtPosition(i).equals(eatingOut.getName())) {
                        recipeOptionsName.remove(adapterView.getItemAtPosition(i));
                        recipeOptions.remove(i);
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });
            s.setAdapter(adapter);
        }
    }
}
