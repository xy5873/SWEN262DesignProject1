package search;

import src.Ingredient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.opencsv.CSVReader;

public class searchIngredients {
    
    private String file = "./data/ingredients.csv";
    private static List<Ingredient> ingredients = new ArrayList<>();

    public searchIngredients(){
        try {
            readFile();
        } catch (Exception e) {
            System.out.println("ERROR: readFile function");
        }
    }
    public void test(){
        String fname = "file.csv";
        List<String[]> r;
        try (CSVReader reader = )
    }
    /**
     * get the data from csv file
     * @return ingredients
     * @throws Exception
     */
    public List<Ingredient> readFile() throws Exception{
        Scanner scanner = new Scanner(new File(file));
        File file = new File(this.file);
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        String[] tempArr;
        // extract ingredient data
        boolean skippedFirstLine = false;
        while((line = br.readLine()) != null){
            if(skippedFirstLine) {
                List<String> ingredient = new ArrayList<>();
                String i_data = line;
                int first = i_data.indexOf("\"");
                int last;
                if(first == -1){ // if no ' " ' is found, go to first comma
                    first = i_data.indexOf(",");
                    last = i_data.indexOf(",", first + 1);
                }
                else {
                    last = i_data.indexOf("\"", first + 1) + 1;
                }

                String name = i_data.substring(first, last);
                i_data = i_data.replace(name, " ");
                name = name.strip();

                String[] data = i_data.split(",");
                int stock_index = data.length - 1;
                int stock = 0;
                if(data[stock_index].equals("")){
                    stock = Integer.parseInt(data[stock_index]);
                }
                Ingredient _ing = new Ingredient(name, stock, data);
                ingredients.add(_ing);
            }
            skippedFirstLine = true;
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
