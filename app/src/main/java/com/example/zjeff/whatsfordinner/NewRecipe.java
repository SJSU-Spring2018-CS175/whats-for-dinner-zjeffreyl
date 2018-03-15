package com.example.zjeff.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class NewRecipe extends AppCompatActivity {
    public ArrayList<RecipeData> savedRecipes;
    public ArrayList<Ingredient> savedIngredients;
    public File fileName;

    //UI data
    public ArrayList<Ingredient> newRecipeIngredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);

        fileName = new File(getFilesDir(), "recipeFile");
        newRecipeIngredients = new ArrayList<Ingredient>();
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");
        savedIngredients = (ArrayList<Ingredient>)bundle.getSerializable("savedIngredients");
        //savedRecipes = new ArrayList<>();
        //savedIngredients = new ArrayList<>();
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
            ArrayList<Ingredient> savedIngredientsList = (ArrayList<Ingredient>) objectInputStream.readObject();
            objectInputStream.close();
            savedRecipes.clear();
            for(int i = 0 ; i < savedRecipeList.size(); i ++){
                savedRecipes.add(savedRecipeList.get(i));
            }
            /*savedIngredients.clear();
            for(int i = 0 ; i < savedIngredientsList.size(); i++){
                savedIngredients.add(savedIngredientsList.get(i));
            }*/
        }catch(Exception exception){
            exception.printStackTrace();
        }
    }

    public void addRecipe(View view){
        EditText name = (EditText)findViewById(R.id.RecipeName);
        String recipeName = name.getText().toString();

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        AutoCompleteTextView ingred1name = (AutoCompleteTextView)findViewById(R.id.ingredient1Name);
        AutoCompleteTextView ingred2name = (AutoCompleteTextView)findViewById(R.id.ingredient2Name);
        AutoCompleteTextView ingred3name = (AutoCompleteTextView)findViewById(R.id.ingredient3Name);
        AutoCompleteTextView ingred4name = (AutoCompleteTextView)findViewById(R.id.ingredient4Name);
        AutoCompleteTextView ingred5name = (AutoCompleteTextView)findViewById(R.id.ingredient5Name);
        AutoCompleteTextView ingred6name = (AutoCompleteTextView)findViewById(R.id.ingredient6Name);
        AutoCompleteTextView ingred7name = (AutoCompleteTextView)findViewById(R.id.ingredient7Name);
        AutoCompleteTextView ingred8name = (AutoCompleteTextView)findViewById(R.id.ingredient8Name);
        AutoCompleteTextView ingred9name = (AutoCompleteTextView)findViewById(R.id.ingredient9Name);
        AutoCompleteTextView ingred10name = (AutoCompleteTextView)findViewById(R.id.ingredient10Name);

        String ingredient1name = ingred1name.getText().toString();
        String ingredient2name = ingred2name.getText().toString();
        String ingredient3name = ingred3name.getText().toString();
        String ingredient4name = ingred4name.getText().toString();
        String ingredient5name = ingred5name.getText().toString();
        String ingredient6name = ingred6name.getText().toString();
        String ingredient7name = ingred7name.getText().toString();
        String ingredient8name = ingred8name.getText().toString();
        String ingredient9name = ingred9name.getText().toString();
        String ingredient10name = ingred10name.getText().toString();

        EditText ingred1amount = (EditText)findViewById(R.id.ingredient1Amount);
        EditText ingred2amount = (EditText)findViewById(R.id.ingredient2Amount);
        EditText ingred3amount = (EditText)findViewById(R.id.ingredient3Amount);
        EditText ingred4amount = (EditText)findViewById(R.id.ingredient4Amount);
        EditText ingred5amount = (EditText)findViewById(R.id.ingredient5Amount);
        EditText ingred6amount = (EditText)findViewById(R.id.ingredient6Amount);
        EditText ingred7amount = (EditText)findViewById(R.id.ingredient7Amount);
        EditText ingred8amount = (EditText)findViewById(R.id.ingredient8Amount);
        EditText ingred9amount = (EditText)findViewById(R.id.ingredient9Amount);
        EditText ingred10amount = (EditText)findViewById(R.id.ingredient10Amount);

        double ingredient1amount = 0;
        if(!ingred1amount.getText().toString().equals("")) {
            ingredient1amount = Double.parseDouble(ingred1amount.getText().toString());
        }
        double ingredient2amount = 0;
        if(!ingred2amount.getText().toString().equals("")) {
            ingredient2amount = Double.parseDouble(ingred2amount.getText().toString());
        }
        double ingredient3amount = 0;
        if(!ingred3amount.getText().toString().equals("")) {
            ingredient3amount = Double.parseDouble(ingred3amount.getText().toString());
        }
        double ingredient4amount = 0;
        if(!ingred4amount.getText().toString().equals("")) {
            ingredient4amount = Double.parseDouble(ingred4amount.getText().toString());
        }
        double ingredient5amount = 0;
        if(!ingred5amount.getText().toString().equals("")) {
            ingredient5amount = Double.parseDouble(ingred5amount.getText().toString());
        }
        double ingredient6amount = 0;
        if(!ingred6amount.getText().toString().equals("")) {
            ingredient6amount = Double.parseDouble(ingred6amount.getText().toString());
        }
        double ingredient7amount = 0;
        if(!ingred7amount.getText().toString().equals("")) {
            ingredient7amount = Double.parseDouble(ingred7amount.getText().toString());
        }
        double ingredient8amount = 0;
        if(!ingred8amount.getText().toString().equals("")) {
            ingredient8amount = Double.parseDouble(ingred8amount.getText().toString());
        }
        double ingredient9amount = 0;
        if(!ingred9amount.getText().toString().equals("")) {
            ingredient9amount = Double.parseDouble(ingred9amount.getText().toString());
        }
        double ingredient10amount = 0;
        if(!ingred10amount.getText().toString().equals("")) {
            ingredient10amount = Double.parseDouble(ingred10amount.getText().toString());
        }

        EditText ingred1unit = (EditText)findViewById(R.id.ingredient1Unit);
        EditText ingred2unit = (EditText)findViewById(R.id.ingredient2Unit);
        EditText ingred3unit = (EditText)findViewById(R.id.ingredient3Unit);
        EditText ingred4unit = (EditText)findViewById(R.id.ingredient4Unit);
        EditText ingred5unit = (EditText)findViewById(R.id.ingredient5Unit);
        EditText ingred6unit = (EditText)findViewById(R.id.ingredient6Unit);
        EditText ingred7unit = (EditText)findViewById(R.id.ingredient7Unit);
        EditText ingred8unit = (EditText)findViewById(R.id.ingredient8Unit);
        EditText ingred9unit = (EditText)findViewById(R.id.ingredient9Unit);
        EditText ingred10unit = (EditText)findViewById(R.id.ingredient10Unit);

        String ingredient1unit = ingred1unit.getText().toString();
        String ingredient2unit = ingred2unit.getText().toString();
        String ingredient3unit = ingred3unit.getText().toString();
        String ingredient4unit = ingred4unit.getText().toString();
        String ingredient5unit = ingred5unit.getText().toString();
        String ingredient6unit = ingred6unit.getText().toString();
        String ingredient7unit = ingred7unit.getText().toString();
        String ingredient8unit = ingred8unit.getText().toString();
        String ingredient9unit = ingred9unit.getText().toString();
        String ingredient10unit = ingred10unit.getText().toString();


        Ingredient ingredient1 = new Ingredient(ingredient1name, ingredient1amount, ingredient1unit);
        Ingredient ingredient2 = new Ingredient(ingredient2name, ingredient2amount, ingredient2unit);
        Ingredient ingredient3 = new Ingredient(ingredient3name, ingredient3amount, ingredient3unit);
        Ingredient ingredient4 = new Ingredient(ingredient4name, ingredient4amount, ingredient4unit);
        Ingredient ingredient5 = new Ingredient(ingredient5name, ingredient5amount, ingredient5unit);
        Ingredient ingredient6 = new Ingredient(ingredient6name, ingredient6amount, ingredient6unit);
        Ingredient ingredient7 = new Ingredient(ingredient7name, ingredient7amount, ingredient7unit);
        Ingredient ingredient8 = new Ingredient(ingredient8name, ingredient8amount, ingredient8unit);
        Ingredient ingredient9 = new Ingredient(ingredient9name, ingredient9amount, ingredient9unit);
        Ingredient ingredient10 = new Ingredient(ingredient10name, ingredient10amount, ingredient10unit);

        ingredients.add(ingredient1);
        ingredients.add(ingredient2);
        ingredients.add(ingredient3);
        ingredients.add(ingredient4);
        ingredients.add(ingredient5);
        ingredients.add(ingredient6);
        ingredients.add(ingredient7);
        ingredients.add(ingredient8);
        ingredients.add(ingredient9);
        ingredients.add(ingredient10);

        //Testing each ingredient against all of the saved ingredients
        /*for(int i = 0; i < ingredients.size(); i++){
            for(int j = 0 ; j < savedIngredients.size(); j++){
                if(ingredients.get(i).getName().equals(savedIngredients.get(i).getName())){
                    ingredients.remove(i);
                }
            }
        }*/

        EditText desc = (EditText) findViewById(R.id.Instructions);
        String description = desc.getText().toString();

        newRecipeIngredients.addAll(ingredients);

        //All values to create one value here
        //name, list of ingredients, descriptions
        //if another name found in save recipes do not add it
        boolean recipeExists = true;
        if(savedRecipes.size() >= 1) {
            for (int j = 0; j < savedRecipes.size(); j++) {
                if (savedRecipes.get(j).getName().equals(recipeName)) {
                    Toast.makeText(getApplicationContext(), "Recipe already exists.", Toast.LENGTH_LONG).show();
                    break;
                } else {
                    recipeExists = false;
                }
            }
        }else{
            recipeExists = false;
        }

        if(recipeExists){
            return;
        }else {
            RecipeData newRecipe = new RecipeData(recipeName, newRecipeIngredients, description);
            savedRecipes.add(newRecipe);
            savedIngredients.addAll(newRecipeIngredients);

            name.getText().clear();

            ingred1name.getText().clear();
            ingred1amount.getText().clear();
            ingred1unit.getText().clear();
            ingred2name.getText().clear();
            ingred2amount.getText().clear();
            ingred2unit.getText().clear();
            ingred3name.getText().clear();
            ingred3amount.getText().clear();
            ingred3unit.getText().clear();
            ingred4name.getText().clear();
            ingred4amount.getText().clear();
            ingred4unit.getText().clear();
            ingred5name.getText().clear();
            ingred5amount.getText().clear();
            ingred5unit.getText().clear();
            ingred6name.getText().clear();
            ingred6amount.getText().clear();
            ingred6unit.getText().clear();
            ingred7name.getText().clear();
            ingred7amount.getText().clear();
            ingred7unit.getText().clear();
            ingred8name.getText().clear();
            ingred8amount.getText().clear();
            ingred8unit.getText().clear();
            ingred9name.getText().clear();
            ingred9amount.getText().clear();
            ingred9unit.getText().clear();
            ingred10name.getText().clear();
            ingred10amount.getText().clear();
            ingred10unit.getText().clear();

            desc.getText().clear();
        }
    }
}
