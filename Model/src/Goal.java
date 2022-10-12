package src;

import java.util.ArrayList;
import java.util.List;

public class Goal {
    private List<Target> targets;
    private int weightGoal;
    private int calorieGoal;


    /**
     * set up the constructor
     * @param weightGoal the goal of the weight
     */
    public Goal(int weightGoal, int calorieGoal){
        this.targets = new ArrayList<>();
        this.weightGoal = weightGoal;
        this.calorieGoal = calorieGoal;
    }


    /**
     * return current target
     * @return return a list of target
     */
    public List<Target> getTargets() {
        return targets;
    }

    /**
     * make some changes for targets list
     * @param targets
     */
    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }


    /**
     * other class can access weightGoal through this method
     * @return the weightGoal
     */
    public int getWeightGoal() {
        return weightGoal;
    }


    /**
     * we can set the weightGoal for the second day
     * @param weightGoal the goal of the weight
     */
    public void setWeightGoal(int weightGoal) {
        this.weightGoal = weightGoal;
    }

    /**
     * other class can access calorieGoal through this method
     * @return the calorieGoal
     */
    public int getCalorieGoal() {
        return calorieGoal;
    }


    /**
     * we can set the calorieGoal for the second day
     * @param calorieGoal the calorie goal
     */
    public void setCalorieGoal(int calorieGoal) {
        this.calorieGoal = calorieGoal;
    }
    
}
