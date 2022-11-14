package src;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import Mediator.TeamMediator;

public class User implements Serializable{
    
    private String username;
    private String password;
    private String name;
    private int height;
    private int weight;
    private Date birthDate;
    private Goal currentGoal;
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

    // /**
    //  * get  the age from birthday 
    //  * @param birthDate the birthday 
    //  * @return the age of the user
    //  */
    // public int getAge(LocalDate birthDate) {
    //     int age = Period.between(birthDate, LocalDate.now()).getYears();
    //     return age;
    // }

    public void setCurrentGoal(Goal currentGoal) {
        this.currentGoal = currentGoal;
    }

    public Goal getCurrentGoal() {
        return currentGoal;
    }

    @Override
    public String toString(){
        return name;
    }

}
