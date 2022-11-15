package src;

import java.util.List;

public class Goal {
    private int weightGoal;
    private goalType type;
    private boolean improveFitness;
    private int calorieTarget;

    private enum goalType {
        maintain,
        lose,
        gain;
    }

    /**
     * set up the constructor
     * @param weightGoal the goal of the weight
     */
    public Goal(int weightGoal, boolean improveFitness){
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
        int goal = 0;
        if (type == goalType.gain) {
            goal = 2750;
        }
        else if (type == goalType.lose) {
            goal = 2250;
        }
        else {
            goal = 2500;
        }
        if (improveFitness) {
            goal = goal - 200;
        }
        return goal;
    }

    /**
     * @return the calorieTarget
     */
    public int getCalorieTarget() {
        return calorieTarget;
    }

    public boolean removeCaloriesFromTarget (int amount) {
        if (calorieTarget - amount >= 0) {
            calorieTarget -= amount;
            return true;
        } else {
            return false;
        }
    }

    public void addCaloriesToTarget (int amount) {
        calorieTarget += amount;
    }

    public void resetTarget () {
        calorieTarget = 0;
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

    @Override
    public String toString() {
        int calorieGoal = getCalorieGoal();
        return "Weight Goal: " + weightGoal + "\nCalorie Goal: " + calorieGoal;
    }
    
}
