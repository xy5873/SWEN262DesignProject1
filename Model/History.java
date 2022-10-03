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

    public int getWeight() {
        return weight;
    }

    public int getTargetCalorie() {
        return targetCalorie;
    }

    public Meal getMeal() {
        return meal;
    }

    public WorkOut getWorkOut() {
        return workOut;
    }


}
