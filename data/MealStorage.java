package data;

import java.util.ArrayList;
import java.util.List;

import src.Meal;

public class MealStorage {

    List<Meal> meals = new ArrayList<>();

    public void add(Object item) {
        meals.add((Meal) item);
    }

    public List<Meal> getAll() {
        return meals;
    }

    public List<String[]> getStrings() {
        List<String[]> mealArr = new ArrayList<>();
        for (Meal meal : this.meals) {
            mealArr.add(meal.getArr());
        }
        return mealArr;
    }

}
