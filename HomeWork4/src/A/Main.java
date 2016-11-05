package A;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Main {
    public static void main(String[] args) {

        Person person1 = new Person("John", "New York");
        System.out.println(person1 instanceof Person);

        Person person3 = new Student("Edward", "Las-Vegas", "Programming", 4, 0);
        Student student1 = new Student("Michel", "San-Francisco", "Math", 5, 0);
        Staff staff1 = new Staff("Lisa", "New Orlean", "1", 5000);

        //Upcast
        Person person2 = new Staff("Richard", "Los-Angeles", "1", 1000);

        System.out.println(person2 instanceof Person);
        System.out.println(person2 instanceof Staff);
        System.out.println(person2 instanceof Student);

        //Downcast
        student1 = (Student) person3;

        System.out.println(person1 instanceof Person);

        staff1 = (Staff) person2;

        System.out.println(staff1 instanceof Person);
        System.out.println(staff1 instanceof Staff);
    }
}
