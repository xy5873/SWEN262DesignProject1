package data;

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
}
