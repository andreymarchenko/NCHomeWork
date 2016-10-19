/**
 * Created by Andrey on 17.10.2016.
 */
class Container {
    private int x1;
    private int y1;
    private int x2;
    private int y2;

    public Container(int x1, int y1, int width, int height) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x1 + width;
        this.y2 = y1 + height;
    }

    public int getX() {
        return x1;
    }

    public int getY() {
        return y1;
    }

    public int getWidth() {
        return Math.abs(this.x1 - this.x2);
    }

    public int getHeight() {
        return Math.abs(this.y1 - this.y2);
    }

    public boolean collides(Ball ball) {
        if (ball.getX() >= this.x1 && ball.getX() <= this.x2
                && ball.getY() >= this.y1 && ball.getY() <= this.y2
                && (ball.getX() - ball.getRadius() >= this.x1 && (ball.getX() + ball.getRadius()) <= this.x2
                && (ball.getY() - ball.getRadius() >= this.y1 && (ball.getY() + ball.getRadius()) <= this.y2)))
            return true;
        else return false;
    }

    @Override
    public String toString() {
        return "Container[(" + this.x1 + "," + this.y1 + "),(" + this.x2 + "," + this.y2 + ")]";

    }
}

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
}
