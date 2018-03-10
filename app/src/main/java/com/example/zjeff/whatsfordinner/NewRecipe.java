package com.example.zjeff.whatsfordinner;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class NewRecipe extends AppCompatActivity {
    public ArrayList<RecipeData> savedRecipes;
    public ArrayList<String> savedIngredients;
    public File fileName;

    //UI data
    public ArrayList<String> newRecipeIngredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        fileName = new File(getFilesDir(), "recipeFile");
        newRecipeIngredients = new ArrayList<String>();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");
        savedIngredients = bundle.getStringArrayList("savedIngredients");
        savedIngredients = new ArrayList<>();
    }

    //write the recipeFile
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(savedRecipes);
            oos.writeObject(savedIngredients);
            oos.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    //write the recipeFile
    @Override
    protected void onStop() {
        super.onStop();
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(savedRecipes);
            oos.writeObject(savedIngredients);
            oos.close();
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            FileInputStream fileInputStream = new FileInputStream(fileName);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ArrayList<RecipeData> savedRecipeList = (ArrayList<RecipeData>) objectInputStream.readObject();
            ArrayList<String> savedIngredientsList = (ArrayList<String>) objectInputStream.readObject();
            objectInputStream.close();
            savedRecipes.clear();
            for(int i = 0 ; i < savedRecipeList.size(); i ++){
                savedRecipes.add(savedRecipeList.get(i));
            }
            savedIngredients.clear();
            for(int i = 0 ; i < savedIngredientsList.size(); i ++){
                savedIngredients.add(savedIngredientsList.get(i));
            }
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public void addRecipe(View view){
        EditText name = (EditText)findViewById(R.id.RecipeName);
        String recipeName = name.getText().toString();

        ArrayList<String> ingredients = new ArrayList<String>();
        AutoCompleteTextView ingred1 = (AutoCompleteTextView)findViewById(R.id.ingredient1);
        String ingredient1 = ingred1.getText().toString();
        ingredients.add(ingredient1);
        AutoCompleteTextView ingred2 = (AutoCompleteTextView)findViewById(R.id.ingredient2);
        String ingredient2 = ingred2.getText().toString();
        ingredients.add(ingredient2);
        AutoCompleteTextView ingred3 = (AutoCompleteTextView)findViewById(R.id.ingredient3);
        String ingredient3 = ingred3.getText().toString();
        ingredients.add(ingredient3);
        AutoCompleteTextView ingred4 = (AutoCompleteTextView)findViewById(R.id.ingredient4);
        String ingredient4 = ingred4.getText().toString();
        ingredients.add(ingredient4);
        AutoCompleteTextView ingred5 = (AutoCompleteTextView)findViewById(R.id.ingredient5);
        String ingredient5 = ingred5.getText().toString();
        ingredients.add(ingredient5);
        AutoCompleteTextView ingred6 = (AutoCompleteTextView)findViewById(R.id.ingredient6);
        String ingredient6 = ingred6.getText().toString();
        ingredients.add(ingredient6);
        AutoCompleteTextView ingred7 = (AutoCompleteTextView)findViewById(R.id.ingredient7);
        String ingredient7 = ingred7.getText().toString();
        ingredients.add(ingredient7);

        EditText desc = (EditText) findViewById(R.id.Instructions);
        String description = desc.getText().toString();

        newRecipeIngredients.addAll(ingredients);

        boolean recipeExists = true;

        for (int j = 0; j < newRecipeIngredients.size(); j++) {
            if(savedRecipes.get(j).getName().equals(recipeName)){
                Toast.makeText(getApplicationContext(), "Recipe already exists.", Toast.LENGTH_LONG).show();
                break;
            }else{
                recipeExists = false;
                break;
            }
        }

        if(recipeExists){
            //add the recipe
            return;
        }else {
            RecipeData newRecipe = new RecipeData(recipeName, newRecipeIngredients, description);
            savedRecipes.add(newRecipe);
            for (int i = 0; i < newRecipeIngredients.size(); i++) {
                if (!savedIngredients.contains(newRecipeIngredients.get(i))) {
                    savedIngredients.add(newRecipeIngredients.get(i));
                }
            }

            ingred1.getText().clear();
            ingred2.getText().clear();
            ingred3.getText().clear();
            ingred4.getText().clear();
            ingred5.getText().clear();
            ingred6.getText().clear();
            ingred7.getText().clear();
            desc.getText().clear();
            name.getText().clear();
        }
    }

}
