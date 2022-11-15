package src;

public class Ingredient {
    private String[] data;

    public static enum E {
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

        E(int index) {
            this.index = index;
        }

        public int get() {
            return index;
        }
    }

    public Ingredient(String[] data) {
        this.data = new String[data.length];
        this.data = data;
    }

    public Ingredient(String name, int cal, int fat, int protein, int fiber, int carbohydrates) {
        this.data = new String[E.STOCK.get() + 1];
        data[E.NAME.get()] = name;
        data[E.STOCK.get()] = "0";
        data[E.CALORIE.get()] = Integer.toString(cal);
        data[E.FAT_SAT.get()] = Integer.toString(fat);
        data[E.PROTEIN.get()] = Integer.toString(protein);
        data[E.FIBER.get()] = Integer.toString(fiber);
        data[E.CARBS.get()] = Integer.toString(carbohydrates);
    }

    /**
     * the name of indredients
     * 
     * @return the name of indredients
     */
    public String getName() {
        String name = data[E.NAME.index];
        return name;
    }

    /**
     * get the stock(number) of the ingredients
     * 
     * @return the number of the ingredients stock
     */
    public int getStock() {
        int stock = Integer.parseInt(data[E.STOCK.index]);
        return stock;
    }

    public int getCalories() {
        int calories = Integer.parseInt(data[E.CALORIE.index]);
        return calories;
    }

    public int getCarbs() {
        int carbs = Integer.parseInt(data[E.CARBS.index]);
        return carbs;
    }

    public int getFat() {
        int fat = Integer.parseInt(data[E.FAT_SAT.index]);
        return fat;
    }

    public int getFiber() {
        int fiber = Integer.parseInt(data[E.FIBER.index]);
        return fiber;
    }

    public int getProtein() {
        int protein = Integer.parseInt(data[E.PROTEIN.index]);
        return protein;
    }

    public int addStock(int amount) {
        int stock = Integer.parseInt(data[E.STOCK.index]);
        stock = stock + amount;
        data[E.STOCK.index] = Integer.toString(stock);
        return stock;
    }

    public boolean removeStock(int amount) {
        int stock = Integer.parseInt(data[E.STOCK.index]);
        if (stock - amount < 0) {
            return false;
        } else {
            stock = stock - amount;
            data[E.STOCK.index] = Integer.toString(stock);
            return true;
        }
    }

    public String[] getArr() {
        return data;
    }

}
