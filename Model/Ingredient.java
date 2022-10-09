public class Ingredient implements Food{
    private String name;
    private int stock;
    

    public Ingredient(String name, int stock){
     this.name = name;
     this.stock = stock;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public void getFood(String name, int numberOfCalories, int gramsOfFat, int gramsOfProtein, int gramsOfFiber,
            int gramOfCarbohydrates) {
        // TODO Auto-generated method stub
        
    }




}
