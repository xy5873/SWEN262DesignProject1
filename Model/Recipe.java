import java.util.ArrayList;
import java.util.List;

public class Recipe implements Food{
    private String name;
    private List<Ingredient> ingredients;
    private String instructions;

    public Recipe(String name, String instrctions){
        this.name = name;
        this.instructions = instrctions;
        this.ingredients = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    @Override
    public void getFood(String name, int numberOfCalories, int gramsOfFat, int gramsOfProtein, int gramsOfFiber,
            int gramOfCarbohydrates) {
        // TODO Auto-generated method stub
        
    }
}
