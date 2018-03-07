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
    //public File fileName;

    public PortraitFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        savedRecipes = new ArrayList<RecipeData>();
        savedRecipesName = new ArrayList<String>();

        Intent intent = getActivity().getIntent();
        Bundle bundle = intent.getExtras();
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");

        for(int i = 0; i < savedRecipes.size(); i++){
            savedRecipesName.add(savedRecipes.get(i).getName());
        }
        View view = inflater.inflate(R.layout.fragment_portrait, container, false);
        ListView listView = (ListView) view.findViewById(R.id.recipeListPortrait);
        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, savedRecipesName);
        listView.setAdapter(listViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //put in meal plan here
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentLongClick = new Intent(getActivity(), EditRecipe.class);
                startActivity(intentLongClick);
                return false;
            }
        });

        return view;
    }

    /*@Override
    public void onStop() {
        super.onStop();
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(savedRecipes);
            oos.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }*/
}
