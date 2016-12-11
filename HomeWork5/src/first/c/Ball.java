package first.c;

/**
 * Created by Andrey on 11.12.2016.
 */
public class Ball {
    private float x;
    private float y;
    private int radius;
    private float xDelta;
    private float yDelta;

    public Ball(float x, float y, int radius, int speed, int direction) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xDelta = (float) (speed * Math.cos(direction));
        this.yDelta = (float) (-speed * Math.sin(direction));
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public float getxDelta() {
        return xDelta;
    }

    public void setxDelta(float xDelta) {
        this.xDelta = xDelta;
    }

    public float getyDelta() {
        return yDelta;
    }

    public void setyDelta(float yDelta) {
        this.yDelta = yDelta;
    }

    public void move() {
        this.x += this.xDelta;
        this.y += this.yDelta;
    }

    public void reflectHorizontal() {
        this.xDelta = -this.xDelta;
    }

    public void reflectVertical() {
        this.yDelta = -this.yDelta;
    }

    @Override
    public String toString() {
        return "Ball[(" + this.x + "," + this.y +
                "),speed=(" + this.xDelta + "," + this.yDelta + ")]";
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Ball)) return false;
        Ball ball = (Ball)o;
        return ball.x == this.x &&
                ball.y == this.y &&
                ball.radius == this.radius &&
                ball.xDelta == this.xDelta &&
                ball.yDelta == this.yDelta;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (int)this.x;
        result = 31 * result + (int)this.y;
        result = 31 * result + (int)this.radius;
        result = 31 * result + (int)this.xDelta;
        result = 31 * result + (int)this.yDelta;
        return result;
    }
}