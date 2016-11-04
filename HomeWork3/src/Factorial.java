/**
 * Created by Andrey on 04.11.2016.
 */
public class Factorial {
    public static int calculateFactorial(int number) {
        int result = 1;
        if (number < 0) throw new IllegalArgumentException("The number must be >= 0");
        if (number > 0) {
            while (number > 0) {
                result *= number;
                number--;
            }
            return result;
        } else {
            return 1;
        }
    }

    public static int recursiveCalculateFactorial(int number) {
        if (number < 0) throw new IllegalArgumentException("The number must be >= 0");
        if (number <= 1) return 1;
        else return number * recursiveCalculateFactorial(number - 1);
    }

    public static void main(String[] args) {
        long startTime;
        long estimatedTime;

        int number = 5;

        startTime = System.nanoTime();
        int a = calculateFactorial(number);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result:" + a + '\n' + "Calculation factorial time: " + estimatedTime);

        startTime = System.nanoTime();
        int b = recursiveCalculateFactorial(number);
        estimatedTime = System.nanoTime() - startTime;
        System.out.println("Result:" + b + '\n' + "Recursive calculation factorial time: " + estimatedTime);
    }
}
