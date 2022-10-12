package src;

public class History {
    private int weight;
    private int targetCalorie;
    private Meal meal;
    private WorkOut workOut;


    public History(int weight, int targetCalorie, Meal meal, WorkOut workOut){
        this.weight = weight;
        this.targetCalorie = targetCalorie;
        this.meal = meal;
        this.workOut = workOut;
    }

    /**
     * get the current weight
     * @return the integer of the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * get the target calories
     * @return integer of target calories
     */
    public int getTargetCalorie() {
        return targetCalorie;
    }

    /**
     * the meal that the person eat for today
     * @return the meal
     */
    public Meal getMeal() {
        return meal;
    }


    /**
     * get the details of the workout
     * @return the workout 
     */
    public WorkOut getWorkOut() {
        return workOut;
    }


}
