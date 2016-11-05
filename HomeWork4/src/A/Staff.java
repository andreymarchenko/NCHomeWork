package A;

import A.Person;

/**
 * Created by Andrey on 05.11.2016.
 */
public class Staff extends Person {
    private String school;
    private double pay;

    Staff(String name, String address, String school, double pay) {
        super(name, address);
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
}
