package E;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Rectangle extends Shape {
    protected double width;
    protected double length;

    public Rectangle() {

    }

    public Rectangle(double width, double length) {
        this.width = width;
        this.length = length;
    }

    public Rectangle(double width, double length, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return this.width * this.length;
    }

    @Override
    public double getPerimetr() {
        return 2 * (this.width + this.length);
    }

    @Override
    public String toString() {
        return "Shape[Rectangle[" + this.width + "," + this.length + "]" + super.getColor() + "," + super.isFilled() + "]";
    }
}
