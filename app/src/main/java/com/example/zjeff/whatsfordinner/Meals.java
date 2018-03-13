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

import java.io.File;
import java.util.ArrayList;

public class Meals extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

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


    public ArrayList<String> recipeOptions = new ArrayList<>();
    File fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        fileName = new File(getFilesDir(), "recipeFile");

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

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if(intent.hasExtra("recipeOptions")) {
            recipeOptions = (ArrayList<String>) bundle.getStringArrayList("recipeOptions");
        }else {
            if (!recipeOptions.contains("Eating out")) {
                recipeOptions.add("Eating out");
            }
        }

        if(intent.hasExtra("selectedRecipeName")) {
            String selectedRecipeName = (String) bundle.getString("selectedRecipeName");
            //added one item to recipe
            recipeOptions.add(selectedRecipeName);
            bundle.remove("selectedRecipeName");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_spinner_view, recipeOptions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        breakfastSpinnerSunday.setAdapter(adapter);
        lunchSpinnerSunday.setAdapter(adapter);
        dinnerSpinnerSunday.setAdapter(adapter);

        breakfastSpinnerMonday.setAdapter(adapter);
        lunchSpinnerMonday.setAdapter(adapter);
        dinnerSpinnerMonday.setAdapter(adapter);

        breakfastSpinnerTuesday.setAdapter(adapter);
        lunchSpinnerTuesday.setAdapter(adapter);
        dinnerSpinnerTuesday.setAdapter(adapter);

        breakfastSpinnerWednesday.setAdapter(adapter);
        lunchSpinnerWednesday.setAdapter(adapter);
        dinnerSpinnerWednesday.setAdapter(adapter);

        breakfastSpinnerThursday.setAdapter(adapter);
        lunchSpinnerThursday.setAdapter(adapter);
        dinnerSpinnerThursday.setAdapter(adapter);

        breakfastSpinnerFriday.setAdapter(adapter);
        lunchSpinnerFriday.setAdapter(adapter);
        dinnerSpinnerFriday.setAdapter(adapter);

        breakfastSpinnerSaturday.setAdapter(adapter);
        lunchSpinnerSaturday.setAdapter(adapter);
        dinnerSpinnerSaturday.setAdapter(adapter);
        //////////////////////////////////////////////////////////
        breakfastSpinnerSunday.setOnItemSelectedListener(this);
        lunchSpinnerSunday.setOnItemSelectedListener(this);
        dinnerSpinnerSunday.setOnItemSelectedListener(this);

        breakfastSpinnerMonday.setOnItemSelectedListener(this);
        lunchSpinnerMonday.setOnItemSelectedListener(this);
        dinnerSpinnerMonday.setOnItemSelectedListener(this);

        breakfastSpinnerTuesday.setOnItemSelectedListener(this);
        lunchSpinnerTuesday.setOnItemSelectedListener(this);
        dinnerSpinnerTuesday.setOnItemSelectedListener(this);

        breakfastSpinnerWednesday.setOnItemSelectedListener(this);
        lunchSpinnerWednesday.setOnItemSelectedListener(this);
        dinnerSpinnerWednesday.setOnItemSelectedListener(this);

        breakfastSpinnerThursday.setOnItemSelectedListener(this);
        lunchSpinnerThursday.setOnItemSelectedListener(this);
        dinnerSpinnerThursday.setOnItemSelectedListener(this);

        breakfastSpinnerFriday.setOnItemSelectedListener(this);
        lunchSpinnerFriday.setOnItemSelectedListener(this);
        dinnerSpinnerFriday.setOnItemSelectedListener(this);

        breakfastSpinnerSaturday.setOnItemSelectedListener(this);
        lunchSpinnerSaturday.setOnItemSelectedListener(this);
        dinnerSpinnerSaturday.setOnItemSelectedListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(getApplicationContext(), Meals.class);
        Bundle b = new Bundle();
        b.putStringArrayList("recipeOptions", recipeOptions);
        intent.putExtras(b);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getItemAtPosition(i).equals("Eating out")){
            return;
        }else {
            recipeOptions.remove(adapterView.getItemAtPosition(i));
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
