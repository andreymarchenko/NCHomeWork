package E;

/**
 * Created by Andrey on 06.11.2016.
 */
public class Square extends Rectangle {
    public Square() {
    }

    public Square(double side) {
        super(side, side);
    }

    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }

    public double getSide() {
        return super.getLength();
    }

    public void setSide(double side) {
        super.setLength(side);
        super.setWidth(side);
    }

    public void setWidth(double side) {
        super.setWidth(side);
    }

    public void setLength(double side) {
        super.setLength(side);
    }

    @Override
    public String toString() {
        return "Shape[Square[" + super.getWidth() + "," + super.getLength() + "]" + super.getColor() + "," + super.isFilled() + "]";
    }
}
