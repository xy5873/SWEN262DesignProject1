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
    private List<Item> items;
    private List<History> history;
    private List<WorkOut> workouts;
    private List<Meal> meals;
    private List<Recipe> recipes;
    private List<Ingredient> ingredients;

    public void add(Object item) {
        // check instance of objectType
        // do switch to add to each list

        items.add((Item) item);
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
                dataArr.add(String.valueOf(item.getItemNum()));
            returnStr = divider + String.join(delimiter, dataArr) + divider;
        } else {
            System.out.println("ERROR: input is not a List< instance of Item >");
        }

        return returnStr;
    }

    public String shortItem(String[] item) {
        return String.join(":", item);
    }
}
