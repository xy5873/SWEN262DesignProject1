package src;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import Mediator.TeamMediator;

public class User implements Serializable{
    
    private String username;
    private String password;
    private String name;
    private int height;
    private int weight;
    private Date birthDate;
    private Goal currentGoal;
    private List<Recipe> recipes;
    private List<Meal> meals;
    private TeamMediator teamMediator;

    public User(TeamMediator teamMediator){
        this.teamMediator = teamMediator;
    }

    public User(String username, String name, int height, int weight, Date date){
        this.username = username;
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthDate = date;
        this.currentGoal = null;
        recipes = new ArrayList<>();
        meals = new ArrayList<>();
    }

    /**
     * get the username of the users
     * @return the username of the user
     */
    public String getUsername() {
        return username;
    }

    /**
     * get the password of the users
     * @return the password of the user
     */
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * get the name of the users
     * @return the name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * change the name of the user
     * @param name new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * get the height of the user
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * change the height of the users
     * @param height new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * get the weight of the users
     * @return the weight 
     */
    public int getWeight() {
        return weight;
    }

    /**
     * change the weight of the users
     * @param weight the new weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * get the birthday of the user
     * @return the birthday
     */
    public Date getBirthDate() {
        return birthDate;
    }

    public void setCurrentGoal(Goal currentGoal) {
        this.currentGoal = currentGoal;
    }

    public Goal getCurrentGoal() {
        return currentGoal;
    }

    /**
     * @return the meals
     */
    public List<Meal> getMeals() {
        return meals;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    /**
     * @return the recipes
     */
    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void addRecipe(Recipe recipe) {
        recipes.add(recipe);
    }
    
    @Override
    public String toString(){
        return name;
    }

}
