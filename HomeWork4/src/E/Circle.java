package E;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Circle extends Shape {

    protected double radius;

    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    @Override
    public double getPerimetr() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        return "Shape[Circle[" + this.radius + "]" + super.getColor() + "," + super.isFilled() + "]";
    }
}
