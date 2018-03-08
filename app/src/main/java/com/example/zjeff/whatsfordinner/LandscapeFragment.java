package com.example.zjeff.whatsfordinner;


import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class LandscapeFragment extends Fragment {
    ArrayList<RecipeData> savedRecipes;
    ArrayList<String> savedRecipesName;
    ArrayList<String> ingredientsDisplay;
    public LandscapeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();

        savedRecipesName = new ArrayList<String>();
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");
        for(int i = 0; i < savedRecipes.size(); i++){
            savedRecipesName.add(savedRecipes.get(i).getName());
        }

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_landscape, container, false);
        ListView listView = (ListView) view.findViewById(R.id.recipeListLandscape);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                    getActivity(),
                    android.R.layout.simple_list_item_1,
                    savedRecipesName
        );

        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView ingText = (TextView)getView().findViewById(R.id.LandscapeIngredientList);
                TextView descText = (TextView)getView().findViewById(R.id.LandscapeDescription);
                TextView nameText = (TextView)getView().findViewById(R.id.LandscapeName);
                String ingredDisplay = "";
                ingText.setText("");
                descText.setText("");
                nameText.setText("");
                //get the arraylist of a recipe
                ingredientsDisplay = savedRecipes.get(i).getIngredients();
                //loop through all the ingredients
                for(int j = 0 ; j < ingredientsDisplay.size(); j++){
                    String ingredTest = ingredientsDisplay.get(j);
                    if(ingredientsDisplay.get(j).equals("")){
                        break;
                    }
                    ingredDisplay = ingredDisplay + ingredientsDisplay.get(j) + System.getProperty("line.separator");
                }
                ingText.setText(ingredDisplay);
                descText.setText(savedRecipes.get(i).getDescription());
                nameText.setText(savedRecipes.get(i).getName());
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
        return view;

    }

}
