package data;

// local
import src.Ingredient;

// External
import java.util.List;

public class IngredientFormatter {
    enum ingredient {
        ITEM_NUM(0),
        NAME(1),
        KCAL(3),
        GmWt_1(48),
        GmWt_Desc1(49),
        GmWt_2(50),
        GmWt_Desc2(51),
        STOCK(52);

        private final int index;

        ingredient(int index) {
            this.index = index;
        }

        public int getIndex() {
            return index;
        }
    }

    // from csv parsing
    public List<Ingredient> toIngredient(String[] item) {

        return null;
    }

    // to csv parsing
    public List<String[]> toCSV(Ingredient ingredient) {

        return null;
    }
}
