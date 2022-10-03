import java.util.ArrayList;
import java.util.List;

public class Goal {
    private List<Target> targets;
    private int weightGoal;


    public Goal(int weightGoal){
        this.targets = new ArrayList<>();
        this.weightGoal = weightGoal;
    }


    public List<Target> getTargets() {
        return targets;
    }


    public void setTargets(List<Target> targets) {
        this.targets = targets;
    }


    public int getWeightGoal() {
        return weightGoal;
    }


    public void setWeightGoal(int weightGoal) {
        this.weightGoal = weightGoal;
    }
    
}
