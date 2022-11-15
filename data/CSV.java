package data;

// External Utilities
import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

// Internal
import src.Date;
import src.History;
import src.Ingredient;
import src.Meal;
import src.Recipe;
import src.WorkOut;
import search.Search;

public class CSV {

    private String historyFile = "data\\history.csv";
    private String workoutFile = "data\\workouts.csv";
    private String mealFile = "data\\meals.csv";
    private String recipeFile = "data\\recipies.csv";
    private String ingredientFile = "data\\ingredients.csv";

    private Storage allData = new Storage();
    private Storage myData = new Storage();
    private Search mySearch = new Search();

    private List<String[]> historyData = new ArrayList<>();
    private List<String[]> workoutData = new ArrayList<>();
    private List<String[]> mealData = new ArrayList<>();
    private List<String[]> recipeData = new ArrayList<>();
    private List<String[]> ingredientData = new ArrayList<>();

    String username;

    public CSV() {
        // All Ingredients
        this.ingredientData = readFile(ingredientFile);
        storeIngredients(allData);
    }

    public CSV(String username) {
        // All History
        this.historyData = readFile(historyFile);
        storeHistory(allData);

        // ALl Workouts
        this.workoutData = readFile(workoutFile);
        storeWorkouts(allData);

        // All Meals
        this.mealData = readFile(mealFile);
        storeMeals(allData);

        // All Recipies
        this.recipeData = readFile(recipeFile);
        storeRecipies(allData);

        this.username = username;
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

    public String[] undoShortItem(String item) {
        return item.split(":");
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

        if (this.historyData.isEmpty() == false) {
            Storage store = this.myData;
            for (String[] historyStr : historyData) {
                if (historyStr[History.E.NAME.get()] == username) {
                    History newHistory = addHistory(historyStr, store);

                    // Workout data
                    String workoutStr = historyStr[History.E.WORKOUT.get()];
                    if (workoutStr.isEmpty() == false) {
                        String[] workoutArr = workoutStr.split(",");
                        List<WorkOut> newWorkouts = myWorkouts(workoutArr, store);

                        for (WorkOut workout : newWorkouts)
                            newHistory.addWorkout(workout);
                    }

                    // meal data
                    String mealStr = historyStr[History.E.MEAL.get()];
                    if (mealStr.isEmpty() == false) {
                        String[] mealArr = mealStr.split(",");
                        List<Meal> newMeals = myMeals(mealArr, store);

                        for (Meal meal : newMeals)
                            newHistory.addMeal(meal);
                    }
                }
            }
        }

        return newHistories;
    }

    public List<WorkOut> myWorkouts(String[] workoutArr, Storage store) {
        List<String[]> found = mySearch.Find(workoutArr, workoutData);
        List<WorkOut> foundWorkouts = new ArrayList<>();
        if (found.isEmpty() == false) {
            // from the given names
            for (String workoutName : workoutArr) {
                // in all the stored data
                for (int i = 0; i < workoutData.size(); i++) {
                    String[] workout = this.workoutData.get(i);
                    // when the name matches save it
                    if (store.undoShortItem(workoutName) == workout) {
                        addWorkout(workout, store);
                        i = workoutData.size(); // break loop
                    }
                }
            }
        }
        return foundWorkouts;
    }

    public List<Meal> myMeals(String[] mealArr, Storage store) {
        List<String[]> found = mySearch.Find(mealArr, mealData);
        List<Meal> foundMeals = new ArrayList<>();
        if (found.isEmpty() == false) {
            // from the given names
            for (String mealName : mealArr) {
                // in all the stored data
                for (int i = 0; i < mealData.size(); i++) {
                    String[] meal = this.mealData.get(i);
                    // when the name matches save it
                    if (store.undoShortItem(mealName) == meal) {
                        addWorkout(meal, store);
                        i = mealData.size(); // break loop
                    }
                }
            }
        }
        return foundMeals;
    }

    // ------------------------------------------------------- Mass Store Data
    // -------------------------------------------------------
    private void storeHistory(Storage store) {
        if (this.historyData.isEmpty() == false) {
            for (String[] History : historyData)
                addHistory(History, store);
        }
    }

    private void storeWorkouts(Storage store) {
        if (this.workoutData.isEmpty() == false) {
            for (String[] workout : workoutData)
                addWorkout(workout, store);
        }
    }

    private void storeMeals(Storage store) {
        if (this.mealData.isEmpty() == false) {
            for (String[] workout : workoutData)
                addMeal(workout, store);
        }
    }

    private void storeRecipies(Storage store) {
        if (this.recipeData.isEmpty() == false) {
            for (String[] recipe : recipeData)
                addRecipe(recipe, store);
        }
    }

    private void storeIngredients(Storage store) {
        if (this.ingredientData.isEmpty() == false) {
            for (String[] ingredient : ingredientData)
                addIngredient(ingredient, store);
        }
    }

    // ------------------------------------------------------- Personal Data
    // -------------------------------------------------------

    private History addHistory(String[] data, Storage store) {
        String name = data[History.E.NAME.get()];
        int weight = Integer.parseInt(data[History.E.WEIGHT.get()]);
        int target = Integer.parseInt(data[History.E.TARGET_C.get()]);

        String[] dateStr = undoShortItem(data[History.E.DATE.get()]);
        Date newDate = new Date(Integer.parseInt(dateStr[0]),
                Integer.parseInt(dateStr[1]),
                Integer.parseInt(dateStr[2]));

        History newHistory = new History(weight, target, newDate);
        newHistory.setName(name);

        store.add(newHistory);
        return newHistory;
    }

    private void addWorkout(String[] data, Storage store) {
        // Duration
        int duration = Integer.valueOf(data[WorkOut.E.DURATION.get()]);

        // Intensity
        String intensityStr = data[WorkOut.E.INTENSITY.get()];
        WorkOut.Intensity intensity = WorkOut.Intensity.valueOf(intensityStr);

        // Date
        String dateStr = data[WorkOut.E.DATE.get()];
        LocalDate date = LocalDate.parse(dateStr);

        store.add(new WorkOut(duration, intensity, date));
    }

    private void addMeal(String[] data, Storage store) {
        // Name
        String name = data[Meal.E.NAME.get()];

        // Recipies
        List<Recipe> recipies = new ArrayList<>();

        Meal newMeal = new Meal(name);
        for (Recipe recipe : recipies)
            newMeal.addRecipe(recipe);

        store.add(newMeal);
    }

    private void addRecipe(String[] data, Storage store) {
        store.add(toRecipe(data));
    }

    private void addIngredient(String[] ingredient, Storage store) {
        store.add(new Ingredient(ingredient));
    }

    private Recipe toRecipe(String[] recipe) {
        // Name
        String name = recipe[Recipe.E.NAME.get()];

        // Instructions
        String instructions = recipe[Recipe.E.INSTRUCTION.get()];

        // Ingredients : find by item num
        Recipe newRecipe = new Recipe(name, instructions);
        String[] allIngredients = recipe[Recipe.E.INGREDIENT.get()].split(",");
        for (String ingredient : allIngredients) {
            String[] ing = undoShortItem(ingredient);
            Ingredient newIngredient = toIngredient(ing[Recipe.INGREDIENT.NAME.get()]);
            if (newIngredient != null) {
                int amount = Integer.valueOf(ing[Recipe.INGREDIENT.AMOUNT.get()]);
                newRecipe.addIngredient(newIngredient, amount);
            }
        }
        return newRecipe;
    }

    private Ingredient toIngredient(String ingredientName) {
        // Find ingredient
        List<String[]> found = mySearch.Find(ingredientName, ingredientData);
        Ingredient foundIngredient = null;
        if (found.isEmpty() == false) {
            // in all the stored data
            for (int i = 0; i < ingredientData.size(); i++) {
                String[] ingr = this.ingredientData.get(i);
                // when the name matches save it
                if (ingredientName == ingr[Ingredient.E.NAME.get()]) {
                    foundIngredient = new Ingredient(ingr);
                    i = mealData.size(); // break loop
                }
            }
        }

        return foundIngredient;
    }
}