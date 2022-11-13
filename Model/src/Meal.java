package src;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private String name;
    private List<Recipe> recipes;
    
    public Meal(String name){
        this.name = name;
        this.recipes = new ArrayList<>();
    }

    /**
     * get the name of the meals.
     * @return a string of name of the users
     */
    public String getName() {
        return name;
    }

    /**
     * get the recipes of the meals
     * @return
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public int getCalories () {
        int cal = 0;
        for (Recipe recipe : recipes) {
            cal = cal + recipe.getCalories();
        }
        return cal;
    }

}
