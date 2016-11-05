package A;

import A.Person;

/**
 * Created by Andrey on 05.11.2016.
 */
public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    Student(String name, String addres, String program, int year, double fee) {
        super(name, addres);
        this.program = program;
        this.year = year;
        this.fee = fee;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "Student[Person[name =" + this.getName() + ",addres" + this.getAddres() + "]," +
                "program=" + this.program + ",year=" + this.year + ",fee=" + this.fee + "]";
    }
}
