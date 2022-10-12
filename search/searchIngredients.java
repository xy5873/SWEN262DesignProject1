package search;
import src.Ingredient;

import java.io.File;
import java.util.*;

public class searchIngredients {
    
    private String file = "./data/ingredients.csv";
    private static List<Ingredient> ingredients = new ArrayList<>();

    public searchIngredients() throws Exception {
        readFile();
    }
    /**
     * get the data from csv file
     * @return ingredients
     * @throws Exception
     */
    public List<Ingredient> readFile() throws Exception{
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter(",");
        // extract ingredient data
        while(scanner.hasNext()){
            List<String> ingredient = new ArrayList<>();
            String i_data = scanner.nextLine();
            int first = i_data.indexOf(",");
            int last = i_data.indexOf(",", first);

            String name = i_data.substring(first, last);
            i_data = i_data.replace(name, " ");
            name = name.strip();

            String[] data = i_data.split(",");
            int stock_index = data.length - 1;
            int stock = Integer.parseInt(data[stock_index]);
            Ingredient _ing = new Ingredient(name, stock, data);
            ingredients.add(_ing);
        }
        scanner.close();
        return ingredients;
    }


    /**
     * get the ingredients from csv files
     * @return the list of all ingredients
     */
    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    /*
    public List<String> findIngredient(String ingredient){
        int max_i = ingredients.size();
        int i = 0;
        while(i < max_i & ingredient.equals(ingredients.get(i++).get(2)) == false);
        if(i < max_i){
            return ingredients.get(i);
        }
        return null;
    }*/
}
