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

public class EditRecipe extends AppCompatActivity {
    public ArrayList<RecipeData> savedRecipes;
    public ArrayList<String> savedIngredients;
    public int position;
    File fileName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position = bundle.getInt("clickedRecipePosition");
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");
        savedIngredients = (ArrayList<String>)bundle.getStringArrayList("savedIngredients");

        fileName = new File(getFilesDir(), "recipeFile");

        EditText name = (EditText)findViewById(R.id.RecipeName);

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

        EditText desc = (EditText) findViewById(R.id.Instructions);

        //Text are set and ready for change
        RecipeData theRecipeData = savedRecipes.get(position);
        name.setText(theRecipeData.getName());

        ingred1name.setText(theRecipeData.getIngredients().get(0).getName());
        ingred2name.setText(theRecipeData.getIngredients().get(1).getName());
        ingred3name.setText(theRecipeData.getIngredients().get(2).getName());
        ingred4name.setText(theRecipeData.getIngredients().get(3).getName());
        ingred5name.setText(theRecipeData.getIngredients().get(4).getName());
        ingred6name.setText(theRecipeData.getIngredients().get(5).getName());
        ingred7name.setText(theRecipeData.getIngredients().get(6).getName());
        ingred8name.setText(theRecipeData.getIngredients().get(7).getName());
        ingred9name.setText(theRecipeData.getIngredients().get(8).getName());
        ingred10name.setText(theRecipeData.getIngredients().get(9).getName());

        ingred1amount.setText(String.valueOf(theRecipeData.getIngredients().get(0).getAmount()));
        ingred2amount.setText(String.valueOf(theRecipeData.getIngredients().get(1).getAmount()));
        ingred3amount.setText(String.valueOf(theRecipeData.getIngredients().get(2).getAmount()));
        ingred4amount.setText(String.valueOf(theRecipeData.getIngredients().get(3).getAmount()));
        ingred5amount.setText(String.valueOf(theRecipeData.getIngredients().get(4).getAmount()));
        ingred6amount.setText(String.valueOf(theRecipeData.getIngredients().get(5).getAmount()));
        ingred7amount.setText(String.valueOf(theRecipeData.getIngredients().get(6).getAmount()));
        ingred8amount.setText(String.valueOf(theRecipeData.getIngredients().get(7).getAmount()));
        ingred9amount.setText(String.valueOf(theRecipeData.getIngredients().get(8).getAmount()));
        ingred10amount.setText(String.valueOf(theRecipeData.getIngredients().get(9).getAmount()));

        ingred1unit.setText(theRecipeData.getIngredients().get(0).getUnit());
        ingred2unit.setText(theRecipeData.getIngredients().get(1).getUnit());
        ingred3unit.setText(theRecipeData.getIngredients().get(2).getUnit());
        ingred4unit.setText(theRecipeData.getIngredients().get(3).getUnit());
        ingred5unit.setText(theRecipeData.getIngredients().get(4).getUnit());
        ingred6unit.setText(theRecipeData.getIngredients().get(5).getUnit());
        ingred7unit.setText(theRecipeData.getIngredients().get(6).getUnit());
        ingred8unit.setText(theRecipeData.getIngredients().get(7).getUnit());
        ingred9unit.setText(theRecipeData.getIngredients().get(8).getUnit());
        ingred10unit.setText(theRecipeData.getIngredients().get(9).getUnit());

        desc.setText(theRecipeData.getDescription());
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

    public void editRecipe(View view){
        ArrayList<Ingredient> inputIngredientsList = new ArrayList<Ingredient>();
        Toast.makeText(this, "Position is " + position, Toast.LENGTH_SHORT).show();

        EditText name = (EditText)findViewById(R.id.RecipeName);

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

        int ingredient1amount = Integer.parseInt(ingred1amount.getText().toString());
        int ingredient2amount = Integer.parseInt(ingred2amount.getText().toString());
        int ingredient3amount = Integer.parseInt(ingred3amount.getText().toString());
        int ingredient4amount = Integer.parseInt(ingred4amount.getText().toString());
        int ingredient5amount = Integer.parseInt(ingred5amount.getText().toString());
        int ingredient6amount = Integer.parseInt(ingred6amount.getText().toString());
        int ingredient7amount = Integer.parseInt(ingred7amount.getText().toString());
        int ingredient8amount = Integer.parseInt(ingred8amount.getText().toString());
        int ingredient9amount = Integer.parseInt(ingred9amount.getText().toString());
        int ingredient10amount = Integer.parseInt(ingred10amount.getText().toString());

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

        inputIngredientsList.add(ingredient1);
        inputIngredientsList.add(ingredient2);
        inputIngredientsList.add(ingredient3);
        inputIngredientsList.add(ingredient4);
        inputIngredientsList.add(ingredient5);
        inputIngredientsList.add(ingredient6);
        inputIngredientsList.add(ingredient7);
        inputIngredientsList.add(ingredient8);
        inputIngredientsList.add(ingredient9);
        inputIngredientsList.add(ingredient10);

        EditText desc = (EditText) findViewById(R.id.Instructions);

        savedRecipes.get(position).setName(name.getText().toString());
        savedRecipes.get(position).setIngredients(inputIngredientsList);
        savedRecipes.get(position).setDescription(desc.getText().toString());

        Intent intent = new Intent(getApplicationContext(), Recipes.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("savedRecipes", savedRecipes);
        intent.putExtras(bundle);
        Toast.makeText(this,"Edited " + savedRecipes.get(position).getName(), Toast.LENGTH_LONG).show();
        startActivity(intent);
    }
}
