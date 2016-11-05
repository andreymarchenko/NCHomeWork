package E;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        //Upcast
        Rectangle rectangle = new Square();
        System.out.println(rectangle instanceof Square);
        System.out.println(rectangle instanceof Rectangle);
        System.out.println(rectangle instanceof Shape);

        //Downcast
        Square square = (Square) rectangle;
        System.out.println(square instanceof Square);
        System.out.println(square instanceof Rectangle);
        System.out.println(square instanceof Shape);
    }
}
