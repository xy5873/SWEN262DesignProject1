package model.src;

public class Ingredient implements Food{
    private String name;
    private int stock;
    

    public Ingredient(String name, int stock){
     this.name = name;
     this.stock = stock;
    }

    /**
     * the name of indredients
     * @return the name of indredients
     */
    public String getName() {
        return name;
    }


    /**
     * get the stock(number) of the ingredients
     * @return the number of the ingredients stock
     */
    public int getStock() {
        return stock;
    }


    /**
     * we need to modify the stock after we are using ingredients
     * @param stock the number of the stock.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    @Override
    public void getFood(String name, int numberOfCalories, int gramsOfFat, int gramsOfProtein, int gramsOfFiber,
            int gramOfCarbohydrates) {
        // TODO Auto-generated method stub
        
    }
}
