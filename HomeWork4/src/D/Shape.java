package D;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Shape {
    private String color = "red";
    private boolean filled = true;

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

    @Override
    public String toString() {
        return "Shape[" + this.color + "," + this.filled + "]";
    }
}
