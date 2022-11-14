package src;

public class Ingredient {
    private String[] data = new String[52];

    public static enum ingredient {
        ITEM_NUM(0),
        NAME(1),
        CALORIE(3),
        PROTEIN(4),
        CARBS(7),
        FIBER(8),
        FAT_SAT(43),
        GmWt_1(48),
        GmWt_Desc1(49),
        GmWt_2(50),
        GmWt_Desc2(51),
        STOCK(52);

        private int index;

        ingredient(int index) {
            this.index = index;
        }

        public int index() {
            return index;
        }
    }

    public Ingredient(String[] data) {
        this.data = data;
    }

    public Ingredient(String name, int cal, int fat,
            int protein, int fiber, int carbohydrates) {
        data[ingredient.NAME.index] = name;
        data[ingredient.STOCK.index] = "0";
        data[ingredient.CALORIE.index] = Integer.toString(cal);
        data[ingredient.FAT_SAT.index] = Integer.toString(fat);
        data[ingredient.PROTEIN.index] = Integer.toString(protein);
        data[ingredient.FIBER.index] = Integer.toString(fiber);
        data[ingredient.CARBS.index] = Integer.toString(carbohydrates);
    }

    /**
     * the name of indredients
     * 
     * @return the name of indredients
     */
    public String getName() {
        String name = data[ingredient.NAME.index];
        return name;
    }

    /**
     * get the stock(number) of the ingredients
     * 
     * @return the number of the ingredients stock
     */
    public int getStock() {
        int stock = Integer.parseInt(data[ingredient.STOCK.index]);
        return stock;
    }

    public int getCalories() {
        int calories = Integer.parseInt(data[ingredient.CALORIE.index]);
        return calories;
    }

    public int getCarbs() {
        int carbs = Integer.parseInt(data[ingredient.CARBS.index]);
        return carbs;
    }

    public int getFat() {
        int fat = Integer.parseInt(data[ingredient.FAT_SAT.index]);
        return fat;
    }

    public int getFiber() {
        int fiber = Integer.parseInt(data[ingredient.FIBER.index]);
        return fiber;
    }

    public int getProtein() {
        int protein = Integer.parseInt(data[ingredient.PROTEIN.index]);
        return protein;
    }

    public int addStock(int amount) {
        int stock = Integer.parseInt(data[ingredient.STOCK.index]);
        stock = stock + amount;
        data[ingredient.STOCK.index] = Integer.toString(stock);
        return stock;
    }

    public boolean removeStock(int amount) {
        int stock = Integer.parseInt(data[ingredient.STOCK.index]);
        if (stock - amount < 0) {
            return false;
        } else {
            stock = stock - amount;
            data[ingredient.STOCK.index] = Integer.toString(stock);
            return true;
        }
    }

    public String getItemNum() {
        return data[ingredient.ITEM_NUM.index];
    }

    public String[] getArr() {
        return data;
    }

}
