package src;

import java.util.ArrayList;
import java.util.List;

public class Recipe implements Item {
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;
    private int recipeNum;
    private static int count = 01000;

    private static enum E {
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

    public Recipe(String[] recipe) {
        // item num, name, instruction, ingredient #, ingr...
        this.recipeNum = Integer.parseInt(recipe[E.ITEM.get()]);
        if (Recipe.count < recipeNum) {
            Recipe.count = recipeNum + 1;
        }
        this.name = recipe[E.NAME.get()];
        this.instructions = recipe[E.INSTRUCTION.get()];
        // String of recipe number
        // search(item num, ingredient storage?)
    }

    public Recipe(String name, String instrctions) {
        this.name = name;
        this.instructions = instrctions;
        this.ingredients = new ArrayList<>();
        recipeNum = Recipe.count++;
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

    public int getItemNum() {
        return recipeNum;
    }

    public String[] getArr() {
        List<String> recipeStr = new ArrayList<>();
        recipeStr.add(Integer.toString(this.recipeNum));
        recipeStr.add(this.name);
        recipeStr.add(this.instructions);

        for (Ingredient ingredient : this.ingredients)
            recipeStr.add(ingredient.getItemNum());

        String[] recipeArr = new String[recipeStr.size()];
        recipeArr = recipeStr.toArray(recipeArr);
        return recipeArr;
    }
}
