/**
 * Created by Andrey on 13.10.2016.
 */
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    Employee(int _id, String _firstName, String _lastName, int _salary) {
        id = _id;
        firstName = _firstName;
        lastName = _lastName;
        salary = _salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAnnualSalary() {
        return salary*12;
    }

    public void raiseSalary(int percent) {
        float p = percent/100;
        this.salary += p*salary;
    }

    public String toString() {
        return ("Employee[id=" + id + ",name=" + firstName + " " + lastName +  ",salary=" + salary + "]");
    }

}

