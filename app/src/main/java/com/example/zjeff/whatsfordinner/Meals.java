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
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Meals extends AppCompatActivity {

    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
    public ArrayList<String> recipeOptions;
    File fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);
        fileName = new File(getFilesDir(), "recipeFile");
        ListView listView = (ListView)findViewById(R.id.DayMeals);

        CustomAdapter customAdapter = new CustomAdapter(recipeOptions);
        listView.setAdapter(customAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(getApplicationContext(), Meals.class);
        Bundle b = new Bundle();
        b.putStringArrayList("recipeOptions", recipeOptions);
        intent.putExtras(b);
    }


    public class CustomAdapter extends BaseAdapter{

        //Displayed list of options
        public ArrayList<String> recipeOptions;
        ArrayAdapter<String> adapter;
        //Recipe selected from Recipes
        String selectedRecipeName;
        Spinner breakfastSpinner;
        Spinner lunchSpinner;
        Spinner dinnerSpinner;

        public CustomAdapter(ArrayList<String> recipeOptions){
            this.recipeOptions = recipeOptions;
        }

        @Override
        public int getCount() {
            return days.length;
        }

        @Override
        public Object getItem(int i) {
            return recipeOptions.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            recipeOptions = new ArrayList<>();
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
                selectedRecipeName = (String) bundle.getString("selectedRecipeName");
                //added one item to recipe
                recipeOptions.add(selectedRecipeName);
            }

            TextView dayTitle = (TextView)view.findViewById(R.id.Day);
            breakfastSpinner = (Spinner) view.findViewById(R.id.BreakfastSpinner);
            lunchSpinner = (Spinner) view.findViewById(R.id.LunchSpinner);
            dinnerSpinner = (Spinner) view.findViewById(R.id.DinnerSpinner);

            Button nutritionManager = (Button)view.findViewById(R.id.Nutrition);

            adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.custom_spinner_view, recipeOptions);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            breakfastSpinner.setAdapter(adapter);
            lunchSpinner.setAdapter(adapter);
            dinnerSpinner.setAdapter(adapter);

            //set days
            dayTitle.setText(days[i]);
            return view;
        }
    }
}
