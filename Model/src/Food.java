package model.src;

public interface Food {

    /**
     * get the specific values from csv file
     * @param name: the name of the user
     * @param numberOfCalories: 
     * @param gramsOfFat
     * @param gramsOfProtein
     * @param gramsOfFiber
     * @param gramOfCarbohydrates
     */
    void getFood(String name, int numberOfCalories, int gramsOfFat, int gramsOfProtein, int gramsOfFiber, 
        int gramOfCarbohydrates);

}
