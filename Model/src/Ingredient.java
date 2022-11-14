package src;

public class Ingredient {
    private String[] data;

    private static enum ingredient {
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

        public int get() {
            return index;
        }
    }

    public Ingredient(String[] data) {
        this.data = data;
    }

    public Ingredient(String name, int cal, int fat, int protein, int fiber, int carbohydrates) {
        this.data = new String[ingredient.STOCK.get()];
        data[ingredient.NAME.get()] = name;
        data[ingredient.STOCK.get()] = "0";
        data[ingredient.CALORIE.get()] = Integer.toString(cal);
        data[ingredient.FAT_SAT.get()] = Integer.toString(fat);
        data[ingredient.PROTEIN.get()] = Integer.toString(protein);
        data[ingredient.FIBER.get()] = Integer.toString(fiber);
        data[ingredient.CARBS.get()] = Integer.toString(carbohydrates);
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
