package src;

public class Ingredient {
    private String name;
    private int stock;
    private String[] i_data;

    public Ingredient(String name, int stock, String[] data) {
        this.name = name;
        this.stock = stock;
        this.i_data = data;
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

    /**
     * we need to modify the stock after we are using ingredients
     * 
     * @param stock the number of the stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    public String[] getIngredientData() {
        return i_data;
    }
}
