package data;

// External Utilities
import java.util.List;

import src.Date;
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

    public Storage loadData(String file) {
        Storage newStorage = new Storage();

        // try history
        // try workouts
        // try meals
        // try recipe
        // no history then jsut ingredients

        return newStorage;
    }

    private String[] splitter(String line) {
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

    public List<String[]> readFile(String file) {
        List<String[]> items = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line = br.readLine(); // Skip first line
            while ((line = br.readLine()) != null) {
                items.add(splitter(line));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("ERROR: Couldnt read input file || " + file);
        }

        return items;
    }

    public List<History> getHistory() {
        List<History> newHistories = new ArrayList<>();
        List<String[]> historyList = readFile(historyFile);
        if (historyList.isEmpty() == false) {
            for (String[] historyStr : historyList) {

                int weight = Integer.parseInt(historyStr[History.E.WEIGHT.get()]);
                int target = Integer.parseInt(historyStr[History.E.TARGET_C.get()]);

                String[] dateStr = splitter(historyStr[History.E.DATE.get()]);
                Date newDate = new Date(Integer.parseInt(dateStr[0]),
                        Integer.parseInt(dateStr[1]),
                        Integer.parseInt(dateStr[2]));
                History newHistory = new History(weight, target, newDate);

                // Workout data
                String workoutStr = historyStr[History.E.WORKOUT.get()];
                if (workoutStr.isEmpty() == false) {
                    String[] workoutArr = splitter(workoutStr);
                    List<WorkOut> newWorkouts = getWorkouts(workoutArr);

                    for (WorkOut workout : newWorkouts)
                        newHistory.addWorkout(workout);
                }

                // meal data
                String mealStr = historyStr[History.E.MEAL.get()];
                if (mealStr.isEmpty() == false) {
                    String[] mealArr = splitter(mealStr);
                    List<Meal> newMeals = getMeals(mealArr);

                    for (Meal meal : newMeals)
                        newHistory.addMeal(meal);
                }
            }
        }

        return newHistories;
    }

    public List<WorkOut> getWorkouts(String[] workouts) {
        List<WorkOut> newWorkouts = new ArrayList<>();

        return newWorkouts;
    }

    public List<Meal> getMeals(String[] meals) {
        List<Meal> newMeals = new ArrayList<>();

        // search for meal using meal num

        // get name: 0
        // get cal: 1
        // get recipies: 2

        return newMeals;
    }

    public List<Recipe> getRecipies(String[] recipes) {
        List<Recipe> newRecipies = new ArrayList<>();

        // item num, name, instruction, ingredient #, ingr...

        // int itemNum = Integer.parseInt(recipe[E.ITEM.get()]);
        // if (Recipe.count < itemNum) {
        // Recipe.count = itemNum + 1;
        // }
        // this.name = recipe[E.NAME.get()];
        // this.instructions = recipe[E.INSTRUCTION.get()];
        // String Ingredients
        // this.ingredients = new Ingredient(recipe[E.INGREDIENT.get()]);

        return newRecipies;
    }

    public List<Ingredient> getIngredients() {
        List<Ingredient> newIngredients = new ArrayList<>();

        return newIngredients;
    }

}