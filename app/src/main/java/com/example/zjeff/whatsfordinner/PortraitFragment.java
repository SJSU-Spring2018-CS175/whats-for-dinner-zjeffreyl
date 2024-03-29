package com.example.zjeff.whatsfordinner;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PortraitFragment extends Fragment {

    ArrayList<RecipeData> savedRecipes;
    ArrayList<String> savedRecipesName;
    ArrayList<RecipeData> sendingRecipes;
    ArrayList<Ingredient> ingredients;

    public PortraitFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        savedRecipes = new ArrayList<RecipeData>();
        savedRecipesName = new ArrayList<String>();

        Intent intent = getActivity().getIntent();
        final Bundle bundle = intent.getExtras();
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");

        ingredients = new ArrayList<>();
        for(int i = 0 ; i < savedRecipes.size(); i++){
            ingredients.addAll(savedRecipes.get(i).getIngredients());
        }

        for(int i = 0; i < savedRecipes.size(); i++){
            savedRecipesName.add(savedRecipes.get(i).getName());
        }

        View view = inflater.inflate(R.layout.fragment_portrait, container, false);
        ListView listView = (ListView) view.findViewById(R.id.recipeListPortrait);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, savedRecipesName);
        listView.setAdapter(listViewAdapter);

        sendingRecipes = new ArrayList<RecipeData>();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Names
                sendingRecipes.add(savedRecipes.get(i));
                Toast.makeText(getActivity(), "Adding " + savedRecipes.get(i).getName() + " into meals", Toast.LENGTH_SHORT).show();

            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentLongClick = new Intent(getActivity(), EditRecipe.class);
                Bundle b = new Bundle();
                b.putInt("clickedRecipePosition", i);
                b.putSerializable("savedRecipes", savedRecipes);
                intentLongClick.putExtras(b);
                startActivity(intentLongClick);
                return false;
            }
        });

        Button button = (Button)view.findViewById(R.id.GoToMeals);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentShortClick = new Intent(getActivity(),Meals.class);
                Bundle b1 = new Bundle();
                b1.putSerializable("selectedRecipeObjects", sendingRecipes);
                intentShortClick.putExtras(b1);
                startActivity(intentShortClick);
            }
        });

        Button button1 = (Button)view.findViewById(R.id.GoToGroceries);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentMain = new Intent(getActivity(), MainActivity.class);
                Bundle b2 = new Bundle();
                b2.putSerializable("GroceriesIngredients", ingredients);
                //intentMain.putExtras(b2);
                //Intent intentMain2 = new Intent(getActivity(), MainActivity.class);
                //Bundle b3 = new Bundle();
                //intentMain.putExtras(b3);
                b2.putSerializable("selectedRecipeObjects", sendingRecipes);
                intentMain.putExtras(b2);
                startActivity(intentMain);
                //startActivity(intentMain2);
            }
        });
        return view;
    }
}
