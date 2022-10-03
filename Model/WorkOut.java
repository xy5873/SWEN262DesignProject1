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

    public int getDuration(){
        return this.duration;
    }

    public int getIntensity(){
        return this.intensity;
    }

    public LocalDate getDate(){
        return this.date;
    }


}
