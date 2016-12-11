package first.d;

/**
 * Created by Andrey on 11.12.2016.
 */
public class Student extends Person {
    private String program;
    private int year;
    private double fee;

    public Student(String name, String addres, String program, int year, double fee) {
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

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return student.program.equals(this.program) &&
                student.year == this.year &&
                student.fee == this.fee;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + this.program.hashCode();
        result = 31 * result + this.year;
        result = 31 * result + (int)this.fee;
        return result;
    }
}
