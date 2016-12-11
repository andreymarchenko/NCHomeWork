package first.d;

/**
 * Created by Andrey on 11.12.2016.
 */
public class Staff extends Person {
    private String school;
    private double pay;

    public Staff(String name, String address, String school, double pay) {
        super(name, address);
        this.school = school;
        this.pay = pay;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }

    @Override
    public String toString() {
        return "Staff[Person[name =" + this.getName() + ",addres" + this.getAddres() + "]," +
                "school=" + this.school + ",pay=" + this.pay + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Staff)) return false;
        Staff staff = (Staff) o;
        return staff.school.equals(this.school) &&
                staff.pay == this.pay;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.school.hashCode();
        result = 31 * result + (int)this.pay;
        return result;
    }
}
