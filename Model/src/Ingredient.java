package src;

public class Ingredient {
    private String name;
    private int stock;
    private int calories;
    private int fat;
    private int protein;
    private int fiber;
    private int carbs;

    public Ingredient(String name, int cal, int fat,
            int protein, int fiber, int carbohydrates) {
        this.name = name;
        this.stock = 0;
        this.calories = cal;
        this.fat = fat;
        this.protein = protein;
        this.fiber = fiber;
        this.carbs = carbohydrates;
    }

    /**
     * the name of indredients
     * 
     * @return the name of indredients
     */
    public String getName() {
        return name;
    }

    /**
     * get the stock(number) of the ingredients
     * 
     * @return the number of the ingredients stock
     */
    public int getStock() {
        return stock;
    }

    public int getCalories() {
        return calories;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getFat() {
        return fat;
    }

    public int getFiber() {
        return fiber;
    }

    public int getProtein() {
        return protein;
    }

    public int addStock(int amount) {
        stock = stock + amount;
        return stock;
    }

    public boolean removeStock(int amount) {
        if (stock - amount < 0) {
            return false;
        } else {
            stock = stock - amount;
            return true;
        }
    }

}
