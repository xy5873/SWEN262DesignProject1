package data;

import java.util.ArrayList;
// External
import java.util.List;

// Internal
import src.Ingredient;

public class IngredientStorage {

    private List<Ingredient> ingredients;

    public void add(Object item) {
        ingredients.add((Ingredient) item);
    }

    public List<Ingredient> getAll() {
        return ingredients;
    }

    public List<String[]> getStrings() {
        List<String[]> stringArr = new ArrayList<>();
        for (Ingredient ingr : ingredients) {
            stringArr.add(ingr.getArr());
        }
        return stringArr;
    }

}
