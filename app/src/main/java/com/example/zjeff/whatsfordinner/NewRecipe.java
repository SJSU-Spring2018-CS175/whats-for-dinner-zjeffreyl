package com.example.zjeff.whatsfordinner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import java.util.ArrayList;

public class NewRecipe extends AppCompatActivity {
    public RecipeData recipeData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_recipe);
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

        EditText desc = (EditText)findViewById(R.id.Instructions);
        String description = desc.getText().toString();

        recipeData = new RecipeData(recipeName, ingredients, description);

        /*Intent intent = new Intent(this, Recipes.class);
        intent.putExtra("recipeName", recipeData.getName());
        intent.putExtra("IngredientsList", recipeData.getIngredients());
        intent.putExtra("recipeDescription", recipeData.getDescription());*/
    }

}
