package first;

import first.a.Author;
import first.a.Book;
import first.b.MyPoint;
import first.b.MyTriangle;
import first.c.Ball;
import first.d.Staff;
import first.d.Student;
import first.e.MyDate;

/**
 * Created by Andrey on 11.12.2016.
 */
public class Main {
    public static void main(String[] args) {
        Author firstAuthor = new Author("John", "Johnson", 'm');
        Author secondAuthor = firstAuthor;
        Author thirdAuthor = new Author("John", "Jn", 'm');

        System.out.println(firstAuthor.equals(secondAuthor));
        System.out.println(firstAuthor.equals(thirdAuthor));
        System.out.println(firstAuthor.hashCode());
        System.out.println(secondAuthor.hashCode());
        System.out.println(thirdAuthor.hashCode());

        Author[] authors = {firstAuthor, thirdAuthor};
        Book firstBook = new Book("Book 1", authors, 199);
        Book secondBook = firstBook;
        Book thirdBook = new Book("Book 2", authors, 199);

        System.out.println(firstBook.equals(secondBook));
        System.out.println(firstBook.equals(thirdBook));
        System.out.println(firstBook.hashCode());
        System.out.println(firstBook.hashCode());

        MyPoint firstPoint = new MyPoint(1, 2);
        MyPoint secondPoint = new MyPoint(5, 2);

        System.out.println(firstPoint.equals(secondPoint));
        System.out.println(firstPoint.hashCode());
        System.out.println(secondPoint.hashCode());

        MyTriangle firstTriangle = new MyTriangle(1, 1, 2, 2, 3, 3);
        MyTriangle secondTriangle = new MyTriangle(2, 2, 3, 3, 4, 5);

        System.out.println(firstTriangle.equals(secondTriangle));
        System.out.println(firstTriangle.hashCode());
        System.out.println(secondTriangle.hashCode());

        Ball firstBall = new Ball(1, 1, 1, 1, 1);
        Ball secondBall = new Ball(2, 2, 2, 2, 2);

        System.out.println(firstBall.equals(secondBall));
        System.out.println(firstBall.hashCode());
        System.out.println(secondBall.hashCode());

        Staff firstStaff = new Staff("Edward", "Russia", "100", 1000);
        Staff secondStaff = new Staff("Edward", "Russia", "100", 2000);

        System.out.println(firstStaff.equals(secondStaff));
        System.out.println(firstBall.hashCode());
        System.out.println(secondStaff.hashCode());

        Student firstStudent = new Student("Lisa", "USA", "Computer techologies", 4, 500);
        Student secondStudent = new Student("Lisa", "USA", "Computer techologies", 4, 600);

        System.out.println(firstStudent.equals(secondStudent));
        System.out.println(firstStudent.hashCode());
        System.out.println(secondStudent.hashCode());

        MyDate firstDate = new MyDate(4, 3, 1);
        MyDate secondDate = new MyDate(2, 3, 1);

        System.out.println(firstDate.equals(secondDate));
        System.out.println(firstDate.hashCode());
        System.out.println(secondDate.hashCode());
    }
}
