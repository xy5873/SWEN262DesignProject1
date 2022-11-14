package data;

import java.util.ArrayList;
import java.util.List;

import src.Recipe;

public class RecipeStorage {

    private List<Recipe> recipies;

    public void add(Object item) {
        recipies.add((Recipe) item);
    }

    public List<Recipe> getAll() {
        return recipies;
    }

    public List<String[]> getStrings() { // Prep recipies for storage
        List<String[]> data = new ArrayList<>();
        for (Recipe recipe : this.recipies) {
            data.add(recipe.getArr());
        }
        return data;
    }
}
