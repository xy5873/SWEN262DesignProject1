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
     * set the new name to the user
     * 
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
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
     * modified the ingredients
     * 
     * @param ingredients
     */
    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    /**
     * get the instructions or how to add something inside the recipe
     * 
     * @return the instructions
     */
    public String getInstructions() {
        return instructions;
    }

    /**
     * modified the instructions
     * 
     * @param instructions the instructions
     */
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

}
