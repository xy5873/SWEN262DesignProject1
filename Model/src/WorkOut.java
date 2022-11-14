package src;

import java.time.LocalDate;

public class WorkOut {
    private int duration;
    private Intensity intensity;
    private LocalDate date;

    public enum Intensity {
        high,
        medium,
        low;
    }

    public WorkOut(int duration, Intensity intensity, LocalDate date){
        this.duration = duration;
        this.intensity = intensity;
        this.date = date;
    }

    /**
     * get the duration of the workout
     * @return
     */
    public int getDuration(){
        return this.duration;
    }

    /**
     * get the intensity of workout
     * @return
     */
    public Intensity getIntensity(){
        return this.intensity;
    }

    /**
     * get the date of the workout
     * @return
     */
    public LocalDate getDate(){
        return this.date;
    }

    /**
     * get the number of calories burned for the workout
     * @return
     */
    public double getCalories(){
        double rate = 0;
        if (intensity == Intensity.high) {
            rate = 10;
        } else if (intensity == Intensity.medium) {
            rate = 7.5;
        } else {
            rate = 5;
        }
        return rate * duration;
    }

    /**
     * overrides toString to get string of workout
     * @return str
     */
    @Override
    public String toString() {        
        double cal = this.getCalories();
        return date.toString() + ":\nDuration: " + duration + "\nIntensity: " + intensity.toString()
                                    + "\nCalories Burned: " + cal;
    }

}
