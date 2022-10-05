package model.src;

import java.time.LocalDate;

public class WorkOut {
    private int duration;
    private int intensity;
    private LocalDate date;

    public WorkOut(int duration, int intensity, LocalDate date){
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
    public int getIntensity(){
        return this.intensity;
    }

    /**
     * get the date of the workout
     * @return
     */
    public LocalDate getDate(){
        return this.date;
    }


}
