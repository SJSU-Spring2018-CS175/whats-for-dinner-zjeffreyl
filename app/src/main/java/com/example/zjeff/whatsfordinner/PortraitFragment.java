package com.example.zjeff.whatsfordinner;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PortraitFragment extends Fragment {

    ArrayList<RecipeData> savedRecipes;
    ArrayList<String> savedRecipesName;

    public PortraitFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");
        savedRecipesName = new ArrayList<String>();
        for(int i = 0; i < savedRecipes.size(); i++){
            savedRecipesName.add(savedRecipes.get(i).getName());
        }
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_portrait, container, false);
        ListView listView = (ListView) view.findViewById(R.id.recipeListPortrait);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, savedRecipesName);
        listView.setAdapter(listViewAdapter);

        /*listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //put in meal plan
            }
        });*/
        return view;
    }


}
