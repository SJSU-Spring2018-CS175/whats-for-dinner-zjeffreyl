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

    public ArrayList<RecipeData> recipeOptions = new ArrayList<>();
    public ArrayList<String> recipeOptionsName = new ArrayList<>();
    File fileName;
    File fileName2;
    RecipeData eatingOut;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        fileName = new File(getFilesDir(), "recipeFile");
        fileName2 = new File(getFilesDir(), "mealFile");
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

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        //Comes second time around
        if(intent.hasExtra("recipeOptions")) {
            recipeOptions = (ArrayList<RecipeData>) bundle.getSerializable("recipeOptions");
        }else {
            if (!recipeOptions.contains(eatingOut)) {
                recipeOptions.add(eatingOut);
            }
        }

        //getting the recipe object
        if(intent.hasExtra("selectedRecipeObject")) {
            RecipeData selectedRecipeObject = (RecipeData) bundle.getSerializable("selectedRecipeObject");
            //added one item to recipe
            recipeOptions.add(selectedRecipeObject);
            bundle.remove("selectedRecipeObject");
        }
        for(int i = 0; i < recipeOptions.size(); i++){
            recipeOptionsName.add(recipeOptions.get(i).getName());
        }

        //adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_spinner_view, recipeOptions);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_spinner_view, recipeOptionsName);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        try {
            FileInputStream fileInputStream = new FileInputStream(fileName2);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<RecipeData> savedRecipeList = (ArrayList<RecipeData>) objectInputStream.readObject();
            ArrayList<Ingredient> savedIngredientsList = (ArrayList<Ingredient>) objectInputStream.readObject();
            objectInputStream.close();
        }catch(Exception exception){
        exception.printStackTrace();
        }
        breakfastSpinnerSunday.setAdapter(adapter);
        lunchSpinnerSunday.setAdapter(adapter);
        dinnerSpinnerSunday.setAdapter(adapter);
        breakfastSpinnerSunday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(recipeOptions.get(i).equals(eatingOut)){
                    return;
                }else {
                    recipeOptionsName.remove(i);
                    recipeOptions.remove(i);
                    Toast.makeText(getApplicationContext(),"" + i, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lunchSpinnerSunday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dinnerSpinnerSunday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        breakfastSpinnerMonday.setAdapter(adapter);
        lunchSpinnerMonday.setAdapter(adapter);
        dinnerSpinnerMonday.setAdapter(adapter);
        breakfastSpinnerMonday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(recipeOptions.get(i).equals(eatingOut)){
                    return;
                }else {
                    recipeOptionsName.remove(i);
                    recipeOptions.remove(i);
                    Toast.makeText(getApplicationContext(),"" + i, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lunchSpinnerMonday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dinnerSpinnerMonday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        breakfastSpinnerTuesday.setAdapter(adapter);
        lunchSpinnerTuesday.setAdapter(adapter);
        dinnerSpinnerTuesday.setAdapter(adapter);
        breakfastSpinnerTuesday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(recipeOptions.get(i).equals(eatingOut)){
                    return;
                }else {
                    recipeOptionsName.remove(i);
                    recipeOptions.remove(i);
                    Toast.makeText(getApplicationContext(),"" + i, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lunchSpinnerTuesday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dinnerSpinnerTuesday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        breakfastSpinnerWednesday.setAdapter(adapter);
        lunchSpinnerWednesday.setAdapter(adapter);
        dinnerSpinnerWednesday.setAdapter(adapter);
        breakfastSpinnerWednesday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(recipeOptions.get(i).equals(eatingOut)){
                    return;
                }else {
                    recipeOptionsName.remove(i);
                    recipeOptions.remove(i);
                    Toast.makeText(getApplicationContext(),"" + i, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lunchSpinnerWednesday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dinnerSpinnerWednesday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        breakfastSpinnerThursday.setAdapter(adapter);
        lunchSpinnerThursday.setAdapter(adapter);
        dinnerSpinnerThursday.setAdapter(adapter);
        breakfastSpinnerThursday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(recipeOptions.get(i).equals(eatingOut)){
                    return;
                }else {
                    recipeOptionsName.remove(i);
                    recipeOptions.remove(i);
                    Toast.makeText(getApplicationContext(),"" + i, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lunchSpinnerThursday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dinnerSpinnerThursday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        breakfastSpinnerFriday.setAdapter(adapter);
        lunchSpinnerFriday.setAdapter(adapter);
        dinnerSpinnerFriday.setAdapter(adapter);
        breakfastSpinnerFriday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(recipeOptions.get(i).equals(eatingOut)){
                    return;
                }else {
                    recipeOptionsName.remove(i);
                    recipeOptions.remove(i);
                    Toast.makeText(getApplicationContext(),"" + i, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lunchSpinnerFriday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dinnerSpinnerFriday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        breakfastSpinnerSaturday.setAdapter(adapter);
        lunchSpinnerSaturday.setAdapter(adapter);
        dinnerSpinnerSaturday.setAdapter(adapter);
        breakfastSpinnerSaturday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(recipeOptions.get(i).equals(eatingOut)){
                    return;
                }else {
                    recipeOptionsName.remove(i);
                    recipeOptions.remove(i);
                    Toast.makeText(getApplicationContext(),"" + i, Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        lunchSpinnerSaturday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        dinnerSpinnerSaturday.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), Groceries.class);
                Bundle b = new Bundle();
                if(adapterView.getItemAtPosition(i).equals("Eating out")){
                    return;
                }else {
                    recipeOptions.remove(adapterView.getItemAtPosition(i));
                    recipeOptions.remove(adapterView.getItemIdAtPosition(i));
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(getApplicationContext(), Meals.class);
        Bundle b = new Bundle();
        b.putSerializable("recipeOptions", recipeOptions);
        intent.putExtras(b);
        try {
            FileOutputStream fos = new FileOutputStream(fileName2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(recipeOptions);
            oos.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Intent intent = new Intent(getApplicationContext(), Meals.class);
        Bundle b = new Bundle();
        b.putSerializable("recipeOptions", recipeOptions);
        intent.putExtras(b);
        try {
            FileOutputStream fos = new FileOutputStream(fileName2);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(recipeOptions);
            oos.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }
}
