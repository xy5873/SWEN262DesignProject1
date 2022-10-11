package src;
import java.time.LocalDate;
import java.time.Period;

public class User {
    
    private String name;
    private int height;
    private int weight;
    private LocalDate birthDate;

    public User(String name, int height, int weight, LocalDate date){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.birthDate = date;
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
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * get  the age from birthday 
     * @param birthDate the birthday 
     * @return the age of the user
     */
    public int getAge(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();
        return age;
    }


}
