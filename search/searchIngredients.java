package search;
import java.io.File;
import java.util.*;

public class searchIngredients {
    
    private String file = "./data/ingredients.csv";
    private List<List<String>> ingredients = new ArrayList<List<String>>();

    /**
     * get the data from csv file
     * @return
     * @throws Exception
     */
    public List<List<String>> readFile() throws Exception{
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        while(scanner.hasNext()){
            List<String> ingredient = new ArrayList<String>();
            ingredient.add(scanner.next());
            ingredients.add(ingredient);
        }
        scanner.close();
        return ingredients;
    }


    /**
     * get the ingredients from csv files
     * @return the list of ingredients
     */
    public List<List<String>> getIngredients() {
        return ingredients;
    }

}
