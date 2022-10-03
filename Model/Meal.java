import java.util.ArrayList;
import java.util.List;

public class Meal implements Food{

    private String name;
    private List<Recipe> recipes;
    
    public Meal(String name){
        this.name = name;
        this.recipes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    @Override
    public void getFood(String name, int numberOfCalories, int gramsOfFat, int gramsOfProtein, int gramsOfFiber,
            int gramOfCarbohydrates) {
        // TODO Auto-generated method stub
        
    }
    

}
