/**
 * Created by Andrey on 13.10.2016.
 */
public class Rectangle {

    private float length = 1.0f;
    private float width = 1.0f;

    Rectangle() {}

    Rectangle (float _length, float _width) {
        length = _length;
        width = _width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getArea() {
        return length*width;
    }

    public float getPerimeer() {
        return 2*(length + width);
    }

    public String toString() {
        return ("Rectangle[length=" + length + ",width=" + width + "]");
    }
}
