package version4;

import java.util.Objects;

public class MyDate implements Cloneable {
    private int day;
    private int month;
    private int year;

    private static final String[] MONTH_NAMES = {
            "", "Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public MyDate() {
        this(1, 1, 2000);
    }

    public MyDate(int day, int month, int year) {
        setDate(day, month, year);
    }

    public int getDay() { return day; }
    public void setDay(int day) { this.day = (day >= 1 && day <= 31) ? day : 1; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = (month >= 1 && month <= 12) ? month : 1; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public void setDate(int day, int month, int year) {
        setYear(year);
        setMonth(month);
        setDay(day);
    }

    @Override
    public String toString() {
        String mStr = (month >= 1 && month <= 12) ? MONTH_NAMES[month] : "Invalid";
        return String.format("%02d %s %d", day, mStr, year);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        MyDate other = (MyDate) obj;
        return day == other.day && month == other.month && year == other.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day, month, year);
    }

    @Override
    public MyDate clone() {
        try {
            return (MyDate) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}