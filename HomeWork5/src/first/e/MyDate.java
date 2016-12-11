package first.e;

/**
 * Created by Andrey on 11.12.2016.
 */
public class MyDate {
    private int year;
    private int month;
    private int day;
    private String[] strMonths = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
            "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private String[] strDays = {"Sunday", "Monday", "Tuesday", "Wednesday",
            "Thursday", "Friday", "Saturday"};
    private int[] daysInMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof MyDate)) return false;
        MyDate myDate = (MyDate) o;
        return myDate.year == this.year &&
                myDate.month == this.month &&
                myDate.day == this.day &&
                strMonths.equals(this.strMonths) &&
                strDays.equals(this.strDays) &&
                daysInMonths.equals(this.daysInMonths);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.year;
        result = 31 * result + this.month;
        result = 31 * result + this.day;
        result = 31 * result + this.strMonths.hashCode();
        result = 31 * result + this.strDays.hashCode();
        result = 31 * result + this.daysInMonths.hashCode();
        return result;
    }
}
