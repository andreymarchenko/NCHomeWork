package B;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Main {
    public static void main(String[] args) {
        //Uocast
        Point2D point2D2 = new Point3D();
        System.out.println(point2D2 instanceof Point2D);
        System.out.println(point2D2 instanceof Point3D);

        //Downcast
        Point3D point3D1 = (Point3D)point2D2;
        System.out.println(point3D1 instanceof Point2D);
        System.out.println(point3D1 instanceof Point3D);


    }
}
