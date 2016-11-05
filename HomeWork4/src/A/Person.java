package A;

/**
 * Created by Andrey on 05.11.2016.
 */
public class Person {
    private String name;
    private String addres;

    public Person(String name, String addres) {
        this.name = name;
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    @Override
    public String toString() {
        return "Person[name=" + this.name + ",addres=" + this.addres + "]";
    }
}
