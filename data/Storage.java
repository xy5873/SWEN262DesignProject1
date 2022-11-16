package data;

import java.util.ArrayList;
import java.util.List;

import src.History;
import src.Ingredient;
import src.Item;
import src.Meal;
import src.Recipe;
import src.WorkOut;

public class Storage {
    private List<Item> items = new ArrayList<>();
    private List<History> history = new ArrayList<>();
    private List<WorkOut> workouts = new ArrayList<>();
    private List<Meal> meals = new ArrayList<>();
    private List<Recipe> recipes = new ArrayList<>();
    private List<Ingredient> ingredients = new ArrayList<>();

    public enum Data {
        HISTORY(0),
        WORKOUT(1),
        MEAL(2),
        RECIPE(3),
        INGREDIENT(4);

        private int id;

        Data(int id) {
            this.id = id;
        }
    }

    public void add(Object object) {
        if (object instanceof History) {
            history.add((History) object);
        } else if (object instanceof WorkOut) {
            workouts.add((WorkOut) object);
        } else if (object instanceof Meal) {
            meals.add((Meal) object);
        } else if (object instanceof Recipe) {
            recipes.add((Recipe) object);
        } else if (object instanceof Ingredient) {
            ingredients.add((Ingredient) object);
        } else {
            System.out.println("ERROR: unrecognized input || " + object);
        }
    }

    public List<Ingredient> getIngredients() {
        return this.ingredients;
    }

    public List<Recipe> getRecipies() {
        return this.recipes;
    }

    public List<Meal> getMeals() {
        return this.meals;
    }

    public List<WorkOut> getWorkouts() {
        return this.workouts;
    }

    public List<History> getHistories() {
        return this.history;
    }

    public List<Item> getAll() {
        return items;
    }

    public List<String[]> getStrings() { // Prep recipies for storage
        List<String[]> data = new ArrayList<>();
        for (Item item : this.items) {
            data.add(((Item) item).getArr());
        }
        return data;
    }

    public String shorthand(List<?> itemList) {
        String returnStr = "";
        if (itemList.get(0) instanceof Item) {
            List<Item> items = (List<Item>) itemList;
            List<String> dataArr = new ArrayList<>();
            String divider = "\"";
            String delimiter = ",";

            for (Item item : items)
                dataArr.add(item.getName());
            returnStr = divider + String.join(delimiter, dataArr) + divider;
        } else {
            System.out.println("ERROR: input is not a List< instance of Item >");
        }

        return returnStr;
    }

    public String shortItem(String[] item) {
        return String.join(":", item);
    }

    public String toSubString(List<String> items) {
        String newString = "\"" + String.join(",", items) + "\"";
        return newString;
    }

    public String[] undoShortItem(String item) {
        return item.split(":");
    }
}
