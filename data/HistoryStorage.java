package data;

// External
import java.util.List;
import java.util.ArrayList;

import javax.xml.crypto.Data;

// Internal
import src.History;
import src.Ingredient;
import src.Meal;
import src.WorkOut;
import src.Date;
import src.Recipe;

public class HistoryStorage {
    public static enum E {
        NAME("NAME", 0),
        DATE("DATE", 1),
        WEIGHT("WEIGHT", 1),
        CAL("CALORIES", 3),
        MEAL("MEAL", 4),
        WORKOUT("WK_OT", 4);

        private String name;
        private int id;

        E(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String Name() {
            return name;
        }

        public int Id() {
            return id;
        }
    }

    public List<String[]> toStrings(History history) {
        List<String[]> csvList = new ArrayList<>();
        int weight = history.getWeight();
        int targ_cal = history.getTargetCalorie();
        Date date = history.getDate();
        List<Meal> meals = history.getMeal();
        // Add all meals to 1 line saved within "
        String[] mealCsv = new String[meals.size() + 5];
        mealCsv[E.NAME.Id()] = " ";
        mealCsv[E.DATE.Id()] = date.toString();
        mealCsv[E.WEIGHT.Id()] = Integer.toString(weight);
        mealCsv[E.CAL.Id()] = Integer.toString(targ_cal);
        mealCsv[E.MEAL.Id()] = E.MEAL.Name();
        for (int i = 5; i < mealCsv.length; i++) {
            for (Meal meal : meals) {
                for (Recipe recipe : meal.getRecipes()) {
                    for (Ingredient ing : recipe.getIngredients()) {

                    }
                }
            }
        }
        // all workouts saved to 1 line
        List<WorkOut> wkout = history.getWorkOut();

        return csvList;
    }

    public History fromString(List<String[]> data) {
        History history = new History(0, 0, null);

        return history;
    }
}
