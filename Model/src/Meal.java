package src;

// External
import java.util.ArrayList;
import java.util.List;

// Internal
import data.Storage;

public class Meal implements Item {

    private String name;
    private List<Recipe> recipes;
    private int mealNum;
    private static int count = 01000;

    public enum E {
        NAME(0),
        RECIPE(1);

        private int index;

        E(int index) {
            this.index = index;
        }

        public int get() {
            return index;
        }
    }

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

        Storage store = new Storage();
        mealList.add(store.shorthand(this.recipes));

        String[] recipeArr = new String[mealList.size()];
        recipeArr = mealList.toArray(recipeArr);
        return recipeArr;
    }

}
