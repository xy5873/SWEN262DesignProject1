package src;

import java.io.Serializable;

public class Date implements Serializable {

    private int day;
    private int month;
    private int year;

    private static int eSize = 3;

    public enum E {
        DAY(0),
        MONTH(1),
        YEAR(2);

        private int i;
        private int size = 3;

        E(int i) {
            this.i = i;
        }

        public int get() {
            return i;
        }
    }

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

    public String[] getArr() {
        String[] dateArr = new String[Date.eSize];
        dateArr[E.DAY.get()] = Integer.toString(this.day);
        dateArr[E.MONTH.get()] = Integer.toString(this.month);
        dateArr[E.YEAR.get()] = Integer.toString(this.year);
        return dateArr;
    }
}
