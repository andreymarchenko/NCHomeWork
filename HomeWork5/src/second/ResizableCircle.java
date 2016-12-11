package second;

/**
 * Created by Andrey on 11.12.2016.
 */
public class ResizableCircle extends Circle implements Resizable {

    public ResizableCircle(double radius) {
        super(radius);
    }

    @Override
    public void resize(int percent) {
        this.radius += radius/100 * percent;
    }
}
