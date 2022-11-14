package data;

import java.util.ArrayList;
// External
import java.util.List;

// Internal
import src.Ingredient;

public class IngredientStorage {

    private List<Ingredient> ingredients;

    public void add(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public List<Ingredient> getAll() {
        return ingredients;
    }

    public List<String[]> geStrings() {
        List<String[]> stringArr = new ArrayList<>();
        for (Ingredient ingr : ingredients) {
            stringArr.add(ingr.getArray());
        }
        return stringArr;
    }
}
