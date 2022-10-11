package src;

import java.util.ArrayList;
import java.util.List;

public class Goal {
    private List<Target> targets;
    private int weightGoal;


    /**
     * set up the constructor
     * @param weightGoal the goal of the weight
     */
    public Goal(int weightGoal){
        this.targets = new ArrayList<>();
        this.weightGoal = weightGoal;
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
    
}
