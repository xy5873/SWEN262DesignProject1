package src;

import java.util.ArrayList;
import java.util.List;

public class Meal {

    private String name;
    private List<Recipe> recipes;

    public Meal(String name) {
        this.name = name;
        this.recipes = new ArrayList<>();
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
     * change the name of the user
     * 
     * @param name the new name of the users
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the recipes of the meals
     * 
     * @return
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    /**
     * modified the recipe of the meal
     * 
     * @param recipes
     */
    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

}
