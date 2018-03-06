package com.example.zjeff.whatsfordinner;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class LandscapeFragment extends Fragment {
    ArrayList<RecipeData> savedRecipes;
    ArrayList<String> savedRecipesName;
    public ArrayList<RecipeData> recipeDataArrayList;

    public LandscapeFragment() {
    }

    /*
    When the device is held in the landscape mode, the recipes screen consists of both the summary list
     and the description of currently selected recipe. The description should show the recipe’s name, image, ingredients, and cooking directions
     */

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             final Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();

        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");
        savedRecipesName = new ArrayList<String>();
        for(int i = 0; i < savedRecipes.size(); i++){
            savedRecipesName.add(savedRecipes.get(i).getName());
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_portrait, container, false);
        ListView listView = (ListView) view.findViewById(R.id.recipeListLandscape);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, savedRecipesName);
        listView.setAdapter(listViewAdapter);

        //
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String description = savedRecipes.get(i).getDescription();
                ArrayList<String> ingredients = savedRecipes.get(i).getIngredients();
                TextView descText = (TextView) getView().findViewById(R.id.RecipeDescription);
                descText.setText(description);

                String ingredDisplay = "";
                for(int j = 0 ; j < ingredients.size(); j++){
                    ingredDisplay = ingredients.get(j) + "/n";
                }
                TextView ingText = (TextView)getView().findViewById(R.id.IngredientsList);
                ingText.setText(ingredDisplay);
            }
        });

        return view;
    }

}
