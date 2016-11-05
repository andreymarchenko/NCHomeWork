package D;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Main {
    public static void main(String[] args) {

        Circle circle1 = new Circle();
        System.out.println(circle1 instanceof Shape);

        //Upcast
        Shape shape1 = new Square();

        System.out.println(shape1 instanceof Square);
        System.out.println(shape1 instanceof Shape);

        Rectangle rectangle1 = new Square();

        System.out.println(rectangle1 instanceof Square);
        System.out.println(rectangle1 instanceof Rectangle);

        Shape shape4 = new Circle();

        System.out.println(shape4 instanceof Square);

        //Downcast
        Rectangle shape2 = (Rectangle) shape1;

        System.out.println(shape2 instanceof Square);
        System.out.println(shape2 instanceof Rectangle);
        System.out.println(shape2 instanceof Shape);

        Square square1 = (Square) shape2;
        System.out.println(square1 instanceof Square);
        System.out.println(square1 instanceof Rectangle);
        System.out.println(square1 instanceof Shape);

    }
}
