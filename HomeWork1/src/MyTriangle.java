/**
 * Created by Andrey on 13.10.2016.
 */
public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        v1.setX(x1);
        v1.setY(y1);
        v2.setX(x2);
        v2.setY(y2);
        v3.setX(x3);
        v3.setY(y3);
    }

    MyTriangle(MyPoint p1, MyPoint p2, MyPoint p3) {
        v1 = p1;
        v2 = p2;
        v3 = p3;
    }

    public String toString() {
        return "MyTriangle[v1=" + v1.toString() + ",v2=" + v2.toString() + ",v3=" + v3.toString() + "]";
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        if((v1.distance(v2) == v2.distance(v3)) && (v3.distance(v1) == v1.distance(v2))) return "Equilateral";
        else if ((v1.distance(v2) == v2.distance(v3)) || (v3.distance(v1) == v1.distance(v2))
                || (v1.distance(v2) == v3.distance(v1))) return "Isosceles";
        else return "Scalene";

    }
}
