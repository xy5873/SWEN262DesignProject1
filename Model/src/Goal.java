package src;

import java.util.List;

public class Goal {
    private int weightGoal;
    private int calorieGoal;
    private goalType type;
    private boolean improveFitness;

    private enum goalType {
        maintain,
        lose,
        gain;
    }

    /**
     * set up the constructor
     * @param weightGoal the goal of the weight
     */
    public Goal(int weightGoal, int currentWeight, boolean improveFitness){
        this.weightGoal = weightGoal;
        this.improveFitness = improveFitness;
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

    public void updateGoal (int currentWeight) {
        if (weightGoal > currentWeight + 5) {
            type = goalType.gain;
        }
        else if (weightGoal < currentWeight - 5) {
            type = goalType.lose;
        }
        else {
            type = goalType.maintain;
        }
    }
    
}
