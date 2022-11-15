package src;

import java.io.Serializable;

public class Date implements Serializable {

    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public String toString() {
        return (month + "/" + day + "/" + year);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getSaveable() {
        String day = Integer.toString(this.day);
        String month = Integer.toString(this.month);
        String year = Integer.toString(this.year);
        return String.format("\"%s: %s: %s\"", day, month, year);
    }
}
