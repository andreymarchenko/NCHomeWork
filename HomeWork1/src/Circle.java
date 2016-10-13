/**
 * Created by Andrey on 13.10.2016.
 */
public class Circle {

    private double radius = 1.0;
    private String color = "red";

    Circle() {}

    Circle(double _radius) {
        radius = _radius;
    }

    Circle(double _radius, String _color) {
        radius = _radius;
        color = _color;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return ("Circle[radius=" + radius + ",color=" + color + "]");
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
