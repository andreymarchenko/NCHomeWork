/**
 * Created by Andrey on 17.10.2016.
 */
public class MainClass {
    public static void main(String[] args) {
        MyComplex a = new MyComplex(0, 1);
        MyComplex b = new MyComplex(-3, 4);
        MyComplex c = new MyComplex(1, 0);
        System.out.println("Number a argument : " + a.argument());
        System.out.println("Is a imaginary? " + a.isImaginary());
        System.out.println("Is c real? " + c.isReal());
        System.out.println("a is equal b? " + a.equals(b));
        System.out.println("a is equal complex number 1i? " + a.equals(0,1));
        System.out.println("Number b magnitude : " + b.magnitude());
        System.out.println("a add b is equal : " + a.add(b));
        System.out.println("a subtract b is equal : " + a.subtract(b));
        System.out.println("a multiply b is equal : " + a.multiply(b));
        System.out.println("a devide b is equal : " + a.devide(b));
        System.out.println("Conjugate a is equal : " + a.conjugate() + "\n");

        double[] arr1 = {1, 1, 1, 1};
        double[] arr2 = {1, 1, 1};
        MyPolinomial p1 = new MyPolinomial(arr1);
        MyPolinomial p2 = new MyPolinomial(arr2);
        System.out.println("Degree p1: " + p1.getDegree());
        System.out.println("Value calculation at the point: " + p1.evaluate(1));
        System.out.println("Summation: " + p1.add(p2));
        System.out.println("Multiplication: " + p1.multiply(p2) + "\n");

        Container container = new Container(0,0,3,3);
        System.out.println(container);
        Ball ball = new Ball(2,2,1,1,0);
        System.out.println(ball);
        System.out.println("Container contains a ball?: " + container.collides(ball));
        ball.move();
        System.out.println(ball);
        System.out.println("Container contains a ball after movement?: " + container.collides(ball));

    }
}
