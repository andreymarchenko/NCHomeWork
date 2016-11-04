import java.util.Random;

/**
 * Created by Andrey on 04.11.2016.
 */
public class DimensionalArrays {

    public static int[] createOddNumbersArray(int size) {
        int[] array = new int[size];
        array[0] = 1;
        for (int i = 1; i < size; i++) {
            array[i] = array[i - 1] + 2;
        }
        return array;
    }

    public static void printInAscendingOrder(int[] array) {
        System.out.print("In ascending order: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void printInDescendingOrder(int[] array) {
        System.out.print("In descending order: ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }

    public static void rangeArray010(int size) {
        int oddNumberSize = 0;
        int evenNumberSize = 0;
        Random random = new Random(0);
        int[] array = new int[size];
        System.out.print("Source array: ");
        for (int i = 0; i < size; i++) {
            array[i] = Math.abs(random.nextInt() % 11);
            if (array[i] % 2 == 0) {
                evenNumberSize++;
            } else oddNumberSize++;
            System.out.print(array[i] + " ");
        }
        System.out.print("\nNumber of odd numbers: " + oddNumberSize + "\nNumber of even numbers: " + evenNumberSize);
    }

    public static void rangeArray1100(int size) {
        Random random = new Random(0);
        int[] array = new int[size];
        System.out.print("Source array: ");
        for (int i = 0; i < size; i++) {
            array[i] = Math.abs(random.nextInt() % 101 + 1);
            System.out.print(array[i] + " ");
        }
        System.out.print('\n' + "Array without 0: ");
        for (int j = 0; j < size; j++) {
            if (j % 2 == 0) {
                array[j] = 0;
            }
            System.out.print(array[j] + " ");
        }
    }

    public static void rangeArray5050(int size) {
        int lastMinIndex = 0;
        int lastMaxIndex = 0;
        Random random = new Random(0);
        int[] array = new int[size];
        System.out.print("Source array: ");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt() % 51;
            System.out.print(array[i] + " ");
        }
        int min = array[0];
        int max = array[0];
        System.out.println("");
        for (int j = 0; j < size; j++) {
            if (array[j] < min) {
                min = array[j];
                lastMinIndex = j + 1;
            }
            if (array[j] > max) {
                max = array[j];
                lastMaxIndex = j + 1;
            }
        }
        System.out.print("The minimum arrays element: " + min + ", Last position of minimum element: " + lastMinIndex);
        System.out.print("\nThe maximum arrays element: " + max + ", Last position of maximum element: " + lastMaxIndex);
    }

    public static void twoRangeArrays010(int size) {
        int sum1 = 0;
        int sum2 = 0;
        Random random = new Random(0);
        int[] array1 = new int[size];
        int[] array2 = new int[size];
        System.out.print("First source array: ");
        for (int i = 0; i < size; i++) {
            array1[i] = Math.abs(random.nextInt() % 11);
            sum1 += array1[i];
            System.out.print(array1[i] + " ");
        }
        System.out.print("\nSecond source array: ");
        for (int i = 0; i < size; i++) {
            array2[i] = Math.abs(random.nextInt() % 11);
            sum2 += array2[i];
            System.out.print(array2[i] + " ");
        }

        if (sum1 / size > sum2 / size) System.out.print("\nThe arithmetic average of the first array more than second");
        if (sum2 / size > sum1 / size) System.out.print("\nThe arithmetic average of the second array more than first");
        if (sum2 / size == sum1 / size)
            System.out.print("\nThe arithmetic average of the second array is equal to the second");
    }

    public static void rangeArray11(int size) {
        int minusOnesNumber = 0;
        int zerosNumber = 0;
        int onesNumber = 0;
        Random random = new Random(0);
        int[] array = new int[size];
        System.out.print("Source array: ");
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt() % 2;
            System.out.print(array[i] + " ");
            if (array[i] == -1) minusOnesNumber++;
            if (array[i] == 0) zerosNumber++;
            if (array[i] == 1) onesNumber++;
        }
        if (minusOnesNumber > zerosNumber && zerosNumber >= onesNumber) System.out.println("\n-1 ");
        if (minusOnesNumber > onesNumber && onesNumber >= zerosNumber) System.out.println("\n-1 ");
        if (zerosNumber > minusOnesNumber && minusOnesNumber >= onesNumber) System.out.println("\n0 ");
        if (zerosNumber > onesNumber && onesNumber >= minusOnesNumber) System.out.println("\n0 ");
        if (onesNumber > minusOnesNumber && minusOnesNumber >= zerosNumber) System.out.println("\n1 ");
        if (onesNumber > zerosNumber && zerosNumber >= minusOnesNumber) System.out.println("\n1 ");

        if (minusOnesNumber == zerosNumber || minusOnesNumber == onesNumber) System.out.println(minusOnesNumber);
        if (zerosNumber == minusOnesNumber || zerosNumber == onesNumber) System.out.println(zerosNumber);
        if (onesNumber == minusOnesNumber || onesNumber == zerosNumber) System.out.println(onesNumber);
        if (onesNumber == minusOnesNumber || minusOnesNumber == zerosNumber) System.out.println(onesNumber);
    }

    public static void main(String[] args) {
        int[] array = new int[50];
        array = createOddNumbersArray(50);
        System.out.print("a) ");
        printInAscendingOrder(array);
        System.out.println("");
        printInDescendingOrder(array);
        System.out.print('\n' + "b) ");
        rangeArray010(20);
        System.out.print('\n' + "c) ");
        rangeArray1100(10);
        System.out.print('\n' + "d) ");
        rangeArray5050(15);
        System.out.print('\n' + "e) ");
        twoRangeArrays010(10);
        System.out.print('\n' + "f) ");
        rangeArray11(20);
    }
}
