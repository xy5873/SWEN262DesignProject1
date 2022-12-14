package src;

import java.time.LocalDate;

public class WorkOut {
    private int duration;
    private Intensity intensity;
    private LocalDate date;

    public enum E {
        DURATION(0),
        INTENSITY(1),
        DATE(2);

        private int index;

        E(int index) {
            this.index = index;
        }

        public int get() {
            return index;
        }
    }

    public enum Intensity {
        high,
        medium,
        low;
    }

    public WorkOut(int duration, Intensity intensity, LocalDate date) {
        this.duration = duration;
        this.intensity = intensity;
        this.date = date;
    }

    /**
     * get the duration of the workout
     * 
     * @return
     */
    public int getDuration() {
        return this.duration;
    }

    /**
     * get the intensity of workout
     * 
     * @return
     */
    public Intensity getIntensity() {
        return this.intensity;
    }

    /**
     * get the date of the workout
     * 
     * @return
     */
    public LocalDate getDate() {
        return this.date;
    }

    /**
     * get the number of calories burned for the workout
     * 
     * @return
     */
    public double getCalories() {
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
     * 
     * @return str
     */
    @Override
    public String toString() {
        double cal = this.getCalories();
        return date.toString() + ":\nDuration: " + duration + "\nIntensity: " + intensity.toString()
                + "\nCalories Burned: " + cal;
    }

    public String[] getArr() {
        String[] workoutArr = new String[4];
        workoutArr[E.DATE.get()] = this.date.toString();
        workoutArr[E.INTENSITY.get()] = this.intensity.toString();
        workoutArr[E.DURATION.get()] = String.valueOf(this.duration);
        return workoutArr;
    }
}
