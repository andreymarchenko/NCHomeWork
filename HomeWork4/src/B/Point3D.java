package B;

/**
 * Created by Andrey on 05.11.2016.
 */
public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {

    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] result = new float[3];
        result[0] = super.getX();
        result[1] = super.getY();
        result[2] = this.z;
        return result;
    }

    @Override
    public String toString() {
        return "(" + super.getX() + "," + super.getY() + "," + this.z + ")";
    }
}
