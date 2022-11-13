package src;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;

    public Recipe(String name, String instrctions) {
        this.name = name;
        this.instructions = instrctions;
        this.ingredients = new ArrayList<>();
    }

    /**
     * get the name of the recipe
     * 
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * get the ingredients from the database
     * 
     * @return
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * get the instructions or how to add something inside the recipe
     * 
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }

    public int getCalories() {
        int cal = 0;
        for (Ingredient ing : ingredients) {
            cal = cal + ing.getCalories();
        }
        return cal;
    }

    public void addIngredient(Ingredient ingredient, int amount) {
        for (int i = 0; i <= amount; i++) {
            ingredients.add(ingredient);
        }
    }

}
