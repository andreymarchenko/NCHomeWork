package C;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Main {
    public static void main(String[] args){

        //Upcast
        Point point2 = new MovablePoint();
        System.out.println(point2 instanceof Point);
        System.out.println(point2 instanceof MovablePoint);

        //Downcast
        MovablePoint movablePoint1 = (MovablePoint) point2;
        System.out.println(movablePoint1 instanceof Point);
        System.out.println(movablePoint1 instanceof MovablePoint);
    }
}
