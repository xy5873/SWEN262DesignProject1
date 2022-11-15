package src;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Item {
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;

    public enum E {
        ITEM(0),
        NAME(1),
        INSTRUCTION(2),
        INGREDIENT(3);

        private int index;

        E(int i) {
            this.index = i;
        }

        public int get() {
            return index;
        }

    }

    public enum INGREDIENT {
        AMOUNT(0),
        NAME(1);

        private int index;

        INGREDIENT(int i) {
            this.index = i;
        }

        public int get() {
            return index;
        }
    }

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

    public String[] getArr() {
        List<String> recipeStr = new ArrayList<>();
        recipeStr.add(this.name);
        recipeStr.add(this.instructions);

        for (Ingredient ingredient : this.ingredients)
            recipeStr.add(ingredient.getName());

        String[] recipeArr = new String[recipeStr.size()];
        recipeArr = recipeStr.toArray(recipeArr);
        return recipeArr;
    }
}
