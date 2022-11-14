package src;

import java.util.ArrayList;
import java.util.List;

public class History {
    private int weight;
    private int targetCalorie;
    private List<Meal> meals;
    private List<WorkOut> workouts;
    private Date date;

    public History(int weight, int targetCalorie, Date date) {
        this.weight = weight;
        this.targetCalorie = targetCalorie;
        this.meals = new ArrayList<>();
        this.workouts = new ArrayList<>();
        this.date = date;
    }

    /**
     * get the current weight
     * 
     * @return the integer of the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * get the target calories
     * 
     * @return integer of target calories
     */
    public int getTargetCalorie() {
        return targetCalorie;
    }

    /**
     * the meal that the person eat for today
     * 
     * @return the meal
     */
    public List<Meal> getMeal() {
        return meals;
    }

    /**
     * get the details of the workout
     * 
     * @return the workout
     */
    public List<WorkOut> getWorkOut() {
        return workouts;
    }

    public Date getDate() {
        return date;
    }

    public double getConsumedVsTarget() {
        int consumed = 0;
        double burned = 0;
        for (Meal meal : meals) {
            consumed = consumed + meal.getCalories();
        }
        for (WorkOut workout : workouts) {
            burned = burned + workout.getCalories();
        }
        double totalCalForDay = consumed - burned;
        return targetCalorie - totalCalForDay;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void addWorkout(WorkOut workout) {
        workouts.add(workout);
    }

    @Override
    public String toString() {
        String history = "";
        double consumedVsTarget = this.getConsumedVsTarget();
        history = history + "History for " + date;
        history = history + "\nWeight = " + weight;
        history = history + "\nCalories consumed v. target = " + consumedVsTarget + "\nMeals:";
        for (Meal meal : meals) {
            history = history + "\n" + meal;
        }
        history = history + "\nWorkouts:";
        for (WorkOut workout : workouts) {
            history = history + "\n" + workout;
        }
        return history;
    }

}
