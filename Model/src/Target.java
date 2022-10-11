package src;

public interface Target {
    
    public boolean wantsLoss = false;
    public boolean isMaintaining = false;

    boolean weight(int currWeight, int GoalWeight);
    boolean calorie(int currCalories, int goalCalories);

}
