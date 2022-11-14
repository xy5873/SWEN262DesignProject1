package src;

import java.util.ArrayList;
import java.util.List;

public class Meal implements Item {

    private String name;
    private List<Recipe> recipes;
    private int mealNum;
    private static int count = 01000;

    public Meal(String name) {
        this.name = name;
        this.recipes = new ArrayList<>();
        this.mealNum = Meal.count++;
    }

    /**
     * get the name of the meals.
     * 
     * @return a string of name of the users
     */
    public String getName() {
        return name;
    }

    /**
     * get the recipes of the meals
     * 
     * @return
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }

    public int getCalories() {
        int cal = 0;
        for (Recipe recipe : recipes) {
            cal = cal + recipe.getCalories();
        }
        return cal;
    }

    public int getItemNum() {
        return this.mealNum;
    }

    @Override
    public String[] getArr() {
        List<String> mealList = new ArrayList<>();
        mealList.add(this.name);
        mealList.add(Integer.toString(this.getCalories()));

        for (Recipe recipe : this.recipes) // store only the recipe num
            mealList.add(Integer.toString(recipe.getItemNum()));

        String[] recipeArr = new String[mealList.size()];
        recipeArr = mealList.toArray(recipeArr);
        return recipeArr;
    }

}
