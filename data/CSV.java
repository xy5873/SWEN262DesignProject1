package data;

// External Utilities
import java.util.List;

import src.History;
import src.Ingredient;
import src.Meal;
import src.Recipe;
import src.WorkOut;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {

    private String historyFile = "data\\history.csv";
    private String workoutFile = "data\\workouts.csv";
    private String mealFile = "data\\meals.csv";
    private String recipeFile = "data\\recipies.csv";
    private String ingredientFile = "data\\ingredients.csv";

    public List<String[]> ImportData(String file) {
        List<String[]> items = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine(); // Skip first line
            while ((line = br.readLine()) != null) {
                items.add(GetLine(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR: Couldnt read input file || " + file);
        }

        return items;
    }

    public String[] GetLine(String line) {
        Character delimiter = ',';
        int last = 0;
        int endOfLine = line.length();
        List<String> info = new ArrayList<>();
        for (int i = 0; i < endOfLine; i++) // checking for substrings that contain commas
        {
            if (line.charAt(i) == delimiter || i == endOfLine - 1) // end of column
            {
                info.add(line.substring(last + 1, i)); // add substring to list
                last = i; // save newest coma - helps identify substring start
            } else if (line.charAt(i) == '\"') // found sub string
            {
                int end = line.indexOf("\"", i + 1); // finding the last part of the pair
                if (end != -1) // -1 meaning pair was not found
                    i = end; // update i so that it doesnt void the string
            }
        }
        // Convert list to array
        String[] strInfo = new String[info.size()];
        return info.toArray(strInfo);
    }

    public void Save(List<String[]> newData, String outFile) throws IOException {
        File csvFile = new File(outFile);
        try {
            FileWriter fileWriter = new FileWriter(csvFile);
            for (String[] data : newData) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < data.length; i++) {
                    line.append(data[i]);
                    if (i != data.length - 1) {
                        line.append(',');
                    }
                }
                line.append("\n");
                fileWriter.write(line.toString());
            }
            fileWriter.close();
        } catch (Exception e) {
            System.out.println("ERROR: Could not write to file || " + outFile);
        }
    }

    public List<String[]> ImportData() {
        List<String[]> items = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            // try history
            // try workouts
            // try meals
            // try recipe
            // no history then jsut ingredients
            String line = br.readLine(); // Skip first line
            while ((line = br.readLine()) != null) {
                items.add(GetLine(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR: Couldnt read input file || " + file);
        }

        return items;
    }

    public List<History> getHistory() throws Exception {

    }

    public List<WorkOut> getWorkouts() throws Exception {

    }

    public List<Meal> getMeals() throws Exception {

    }

    public List<Recipe> getRecipies() throws Exception {

    }

    public List<Ingredient> getIngredients() throws Exception {

    }

}