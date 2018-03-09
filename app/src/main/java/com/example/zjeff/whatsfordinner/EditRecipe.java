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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_recipe);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        position = bundle.getInt("clickedRecipePosition");
        savedRecipes = (ArrayList<RecipeData>)bundle.getSerializable("savedRecipes");

        EditText name = (EditText)findViewById(R.id.RecipeName);
        AutoCompleteTextView ingred1 = (AutoCompleteTextView)findViewById(R.id.ingredient1);
        AutoCompleteTextView ingred2 = (AutoCompleteTextView)findViewById(R.id.ingredient2);
        AutoCompleteTextView ingred3 = (AutoCompleteTextView)findViewById(R.id.ingredient3);
        AutoCompleteTextView ingred4 = (AutoCompleteTextView)findViewById(R.id.ingredient4);
        AutoCompleteTextView ingred5 = (AutoCompleteTextView)findViewById(R.id.ingredient5);
        AutoCompleteTextView ingred6 = (AutoCompleteTextView)findViewById(R.id.ingredient6);
        AutoCompleteTextView ingred7 = (AutoCompleteTextView)findViewById(R.id.ingredient7);
        EditText desc = (EditText) findViewById(R.id.Instructions);

        //Text are set and ready for change
        RecipeData theRecipeData = savedRecipes.get(position);
        name.setText(theRecipeData.getName());
        ingred1.setText(theRecipeData.getIngredients().get(0));
        ingred2.setText(theRecipeData.getIngredients().get(1));
        ingred3.setText(theRecipeData.getIngredients().get(2));
        ingred4.setText(theRecipeData.getIngredients().get(3));
        ingred5.setText(theRecipeData.getIngredients().get(4));
        ingred6.setText(theRecipeData.getIngredients().get(5));
        ingred7.setText(theRecipeData.getIngredients().get(6));
        desc.setText(theRecipeData.getDescription());
    }

    public void editRecipe(View view){
        ArrayList<String> inputIngredientsList = new ArrayList<String>();
        Toast.makeText(this, "Position is " + position, Toast.LENGTH_SHORT).show();

        EditText name = (EditText)findViewById(R.id.RecipeName);

        AutoCompleteTextView ingred1 = (AutoCompleteTextView)findViewById(R.id.ingredient1);
        AutoCompleteTextView ingred2 = (AutoCompleteTextView)findViewById(R.id.ingredient2);
        AutoCompleteTextView ingred3 = (AutoCompleteTextView)findViewById(R.id.ingredient3);
        AutoCompleteTextView ingred4 = (AutoCompleteTextView)findViewById(R.id.ingredient4);
        AutoCompleteTextView ingred5 = (AutoCompleteTextView)findViewById(R.id.ingredient5);
        AutoCompleteTextView ingred6 = (AutoCompleteTextView)findViewById(R.id.ingredient6);
        AutoCompleteTextView ingred7 = (AutoCompleteTextView)findViewById(R.id.ingredient7);
        inputIngredientsList.add(ingred1.getText().toString());
        inputIngredientsList.add(ingred2.getText().toString());
        inputIngredientsList.add(ingred3.getText().toString());
        inputIngredientsList.add(ingred4.getText().toString());
        inputIngredientsList.add(ingred5.getText().toString());
        inputIngredientsList.add(ingred6.getText().toString());
        inputIngredientsList.add(ingred7.getText().toString());

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
