package com.example.zjeff.whatsfordinner;

import android.content.pm.ApplicationInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.baoyz.swipemenulistview.SwipeMenu;
import com.baoyz.swipemenulistview.SwipeMenuCreator;
import com.baoyz.swipemenulistview.SwipeMenuItem;
import com.baoyz.swipemenulistview.SwipeMenuListView;

import java.util.ArrayList;
import java.util.List;

public class Groceries extends AppCompatActivity {
    ArrayList<Ingredient> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Bundle b = getIntent().getExtras();
        list = new ArrayList<>();
        list = (ArrayList<Ingredient>) getIntent().getExtras().getSerializable("GroceriesIngredients");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
        SwipeMenuListView listView = (SwipeMenuListView) findViewById(R.id.listView);

        ArrayList<String> formatted = new ArrayList<>();
        for(int i = 0 ; i < list.size(); i++){
            if(list.get(i).getAmount() != 0) {
                formatted.add(list.get(i).getName() + " ( " + list.get(i).getAmount() + " " + list.get(i).getUnit().toString() + " )");
            }
        }

        ArrayAdapter adapter = new ArrayAdapter(Groceries.this, android.R.layout.simple_list_item_1, formatted);
        listView.setAdapter(adapter);

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
                openItem.setTitle("Add");
                // set item title fontsize
                openItem.setTitleSize(18);
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
                        break;
                    case 1:
                        // delete
                        break;
                }
                // false : close the menu; true : not close the menu
                return false;
            }
        });
    }
}
