package com.example.zjeff.whatsfordinner;

import android.content.pm.ApplicationInfo;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Groceries extends AppCompatActivity {
    ArrayList<Ingredient> list;
    ArrayList<String> formatted;
    ArrayList<Double> unchangedIngredientAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Bundle b = getIntent().getExtras();
        list = new ArrayList<>();
        unchangedIngredientAmount = new ArrayList<>();
        list = (ArrayList<Ingredient>) getIntent().getExtras().getSerializable("GroceriesIngredients");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
        final SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);
        formatted = new ArrayList<>();
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getAmount() != 0) {
                unchangedIngredientAmount.add(list.get(i).getAmount());
            }
        }
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i).getAmount() != 0) {
                //sett all values to default but list should not change
                formatted.add(list.get(i).getName() + " ( " + list.get(i).getAmount() + " " + list.get(i).getUnit().toString() + " )");
            }
        }

        //Source code and gradle build from github.com/baoyongzhang/SwipeMenuListView
        final ArrayAdapter adapter = new ArrayAdapter(Groceries.this, android.R.layout.simple_list_item_1, formatted);
        //Sourced from
        SwipeMenuCreator creator = new SwipeMenuCreator() {

            @Override
            public void create(SwipeMenu menu) {
                // create "open" item
                SwipeMenuItem openItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                openItem.setBackground(new ColorDrawable(Color.rgb(0xC9, 0xC9,
                        0xCE)));
                // set item width
                openItem.setWidth(170);
                // set item title
                openItem.setIcon(R.drawable.ic_add);
                // set item title fontsize
                //openItem.setTitleSize(18);
                // set item title font color
                openItem.setTitleColor(Color.WHITE);
                // add to menu
                menu.addMenuItem(openItem);

                // create "delete" item
                SwipeMenuItem deleteItem = new SwipeMenuItem(
                        getApplicationContext());
                // set item background
                deleteItem.setBackground(new ColorDrawable(Color.rgb(0xF9,
                        0x3F, 0x25)));
                // set item width
                deleteItem.setWidth(170);
                // set a icon
                deleteItem.setIcon(R.drawable.ic_delete);
                // add to menu
                menu.addMenuItem(deleteItem);
            }
        };
        listView.setMenuCreator(creator);

        listView.setOnMenuItemClickListener(new SwipeMenuListView.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(int position, SwipeMenu menu, int index) {
                switch (index) {
                    case 0:
                        // open
                        //need to add amount to current
                        double d = 0;
                        Matcher m = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(formatted.get(position));
                        while (m.find())
                        {
                            d = Double.parseDouble(m.group(1));
                        }
                        double addedAmount = unchangedIngredientAmount.get(position) + d;
                        formatted.set(position, list.get(position).getName() + " ( " + addedAmount+ " " + list.get(position).getUnit().toString() + " )");
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        double d1 = 0;
                        Matcher m1 = Pattern.compile("(?!=\\d\\.\\d\\.)([\\d.]+)").matcher(formatted.get(position));
                        while (m1.find())
                        {
                            d1 = Double.parseDouble(m1.group(1));
                        }
                        double deletedAmount = d1 - list.get(position).getAmount();
                        formatted.set(position, list.get(position).getName() + " ( " + deletedAmount+ " " + list.get(position).getUnit().toString() + " )");
                        if(deletedAmount < 0){
                            formatted.remove(position);
                        }
                        adapter.notifyDataSetChanged();
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
        listView.setAdapter(adapter);
    }

    public double getCurrentAmount(ArrayList<String> formatted, int position, int amount){
        formatted.add(list.get(position).getName() + " ( " + amount + " " + list.get(position).getUnit().toString() + " )");
        return amount;
    }
}
