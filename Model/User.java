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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public int getAge(LocalDate birthDate) {
        int age = Period.between(birthDate, LocalDate.now()).getYears();

        return age;
    }


}
