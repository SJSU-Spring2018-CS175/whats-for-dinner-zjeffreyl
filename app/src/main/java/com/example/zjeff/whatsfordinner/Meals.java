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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Meals extends AppCompatActivity {

    //Displayed list of options
    public ArrayList<String> recipeOptions;
    //Recipe selected from Recipes
    String selectedRecipeName;
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        /*recipeOptions = new ArrayList<>();

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
        }
        recipeOptions.add(selectedRecipeName);
    */
        ListView listView = (ListView)findViewById(R.id.DayMeals);

        CustomAdapter customAdapter = new CustomAdapter();
        listView.setAdapter(customAdapter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        Intent intent = new Intent(getApplicationContext(), Meals.class);
        Bundle b = new Bundle();
        //b.putStringArrayList("recipeOptions", recipeOptions);
        intent.putExtras(b);
    }

    class CustomAdapter extends BaseAdapter{
        public CustomAdapter(){

        }
        @Override
        public int getCount() {
            return days.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            view = getLayoutInflater().inflate(R.layout.customlayout, null);
            TextView dayTitle = (TextView)view.findViewById(R.id.Day);
            ExpandableListView recipeOptionsB = (ExpandableListView)view.findViewById(R.id.FoodOptionsBreakfast);
            ExpandableListView recipeOptionsL = (ExpandableListView)view.findViewById(R.id.FoodOptionsLunch);
            ExpandableListView recipeOptionsD = (ExpandableListView)view.findViewById(R.id.FoodOptionsDinner);
            Button nutritionManager = (Button)view.findViewById(R.id.Nutrition);
            //set days
            dayTitle.setText(days[i]);
            //set expandable list view to fill up with arraylist
            //Just need to set to the same list over and over
            /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, recipeOptions);
            recipeOptionsB.setAdapter(arrayAdapter);
            recipeOptionsL.setAdapter(arrayAdapter);
            recipeOptionsD.setAdapter(arrayAdapter);*/
            return view;
        }
    }
}
