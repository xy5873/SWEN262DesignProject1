package src;

import java.time.LocalDate;

public class WorkOut {
    private int duration;
    private double intensity;
    private LocalDate date;

    public WorkOut(int duration, double intensity, LocalDate date){
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
    public double getIntensity(){
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
    public double getCalories(double intensity, int time){
        return intensity * time;
    }

    /**
     * overrides toString to get string of workout
     * @return str
     */
    @Override
    public String toString() {        
        String str = ("duration: " + getDuration() + " min\nintensity: " + getIntensity() 
                        + " calories/min\ndate: " + getDate() + "\ncalories burned: " + getCalories(getIntensity(), getDuration()));
        return str;
    }

}
