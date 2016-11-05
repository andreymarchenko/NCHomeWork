package E;

/**
 * Created by Andrey on 06.11.2016.
 */
public abstract class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public boolean isFilled() {
        if (filled) return true;
        else return false;
    }

    public abstract double getArea();

    public abstract double getPerimetr();

    public abstract String toString();

}
