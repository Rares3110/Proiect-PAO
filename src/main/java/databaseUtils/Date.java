package databaseUtils;

public class Date implements Comparable<Date> {
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDay(int day) {
        this.day = day;
    }
    public void setMonth(int month) {
        this.month = month;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public int getDay() {
        return this.day;
    }
    public int getMonth() {
        return this.month;
    }
    public int getYear() {
        return this.year;
    }

    public String toString() {
        return Integer.valueOf(this.day).toString() + "."
                + Integer.valueOf(this.month).toString() + "."
                + Integer.valueOf(this.year).toString();
    }

    public int compareTo(Date o) {
        int value = Integer.compare(this.year, o.year);

        if (value == 0) {
            value = Integer.compare(this.month, o.month);
        }

        if (value == 0) {
            value = Integer.compare(this.day, o.day);
        }

        return value;
    }

    public static Date parse(String sir) {
        String[] data = sir.split("\\.");
        return new Date(Integer.parseInt(data[0]), Integer.parseInt(data[1]), Integer.parseInt(data[2]));
    }
}
