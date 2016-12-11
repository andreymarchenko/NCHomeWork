package first.b;

/**
 * Created by Andrey on 11.12.2016.
 */
public class MyTriangle {
    private MyPoint v1;
    private MyPoint v2;
    private MyPoint v3;

    public MyTriangle(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.v1 = new MyPoint();
        this.v2 = new MyPoint();
        this.v3 = new MyPoint();
        this.v1.setX(x1);
        this.v1.setY(y1);
        this.v2.setX(x2);
        this.v2.setY(y2);
        this.v3.setX(x3);
        this.v3.setY(y3);
    }

    public MyTriangle(MyPoint p1, MyPoint p2, MyPoint p3) {
        this.v1 = p1;
        this.v2 = p2;
        this.v3 = p3;
    }

    public String toString() {
        return "MyTriangle[v1=" + v1.toString() + ",v2=" + v2.toString() + ",v3=" + v3.toString() + "]";
    }

    public double getPerimeter() {
        return v1.distance(v2) + v2.distance(v3) + v3.distance(v1);
    }

    public String getType() {
        if ((v1.distance(v2) == v2.distance(v3)) && (v3.distance(v1) == v1.distance(v2))) return "Equilateral";
        else if ((v1.distance(v2) == v2.distance(v3)) || (v3.distance(v1) == v1.distance(v2))
                || (v1.distance(v2) == v3.distance(v1))) return "Isosceles";
        else return "Scalene";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof MyTriangle)) return false;
        MyTriangle triangle = (MyTriangle)o;
        return triangle.v1.equals(this.v1) &&
                triangle.v2.equals(this.v2) &&
                triangle.v3.equals(this.v3);
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + this.v1.hashCode();
        result = 31 * result + this.v2.hashCode();
        result = 31 * result + this.v3.hashCode();
        return result;
    }
}

