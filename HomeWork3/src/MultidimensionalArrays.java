import java.util.Arrays;
import java.util.Random;

/**
 * Created by Andrey on 04.11.2016.
 */
public class MultidimensionalArrays {
    public static void initializeArray(int[][] array, int rowSize, int columnSize, int min, int max) {
        Random random = new Random(0);
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (min >= 0)
                    array[i][j] = Math.abs(random.nextInt() % (max + 1 - min)) + min;
                else array[i][j] = random.nextInt() % (max + 1);
            }
        }
    }

    public static void printArray(int[][] array, int rowSize, int columnSize) {
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (j == columnSize - 1) {
                    System.out.print(array[i][j]);
                    System.out.println("");
                } else System.out.print(array[i][j] + " ");
            }
        }
    }


    public static void a(int rowSize, int columnSize, int min, int max) {
        int[][] array = new int[rowSize][columnSize];
        initializeArray(array, rowSize, columnSize, min, max);
        printArray(array, rowSize, columnSize);
        long mainDiagonalProduction = 1;
        long sideDiagonalProduction = 1;
        int mainDiagonalSum = 0;
        int sideDiagonalSum = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (i == j) {
                    mainDiagonalProduction *= array[i][j];
                    mainDiagonalSum += array[i][j];
                }
                if (i == columnSize - j - 1) {
                    sideDiagonalProduction *= array[i][j];
                    sideDiagonalSum += array[i][j];
                }
            }
        }
        System.out.print("\nSum of main diagonals elements: " + mainDiagonalSum);
        System.out.print("\nProduction of main diagonals elements: " + mainDiagonalProduction);
        System.out.print("\nSum of side diagonals elements: " + sideDiagonalSum);
        System.out.print("\nProduction of side diagonals elements: " + sideDiagonalProduction);
    }

    public static void b(int rowSize, int columnSize, int min, int max) {
        int[] vec = new int[3];
        int[][] array = new int[rowSize][columnSize];
        initializeArray(array, rowSize, columnSize, min, max);
        printArray(array, rowSize, columnSize);
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                if (vec[0] < array[i][j]) {
                    vec[0] = array[i][j];
                    vec[1] = i;
                    vec[2] = j;
                }
            }
        }
        System.out.print("\nThe maximum arrays element: " + vec[0] +
                "\nIndexes of maximum arrays element: " + vec[1] + "," + vec[2]);
    }

    public static void c(int rowSize, int columnSize, int min, int max) {
        int vec[] = new int[rowSize];
        for (int i = 0; i < vec.length; i++) {
            vec[i] = 1;
        }
        int maxIndex = 0;
        int maxValue = 0;
        int[][] array = new int[rowSize][columnSize];
        initializeArray(array, rowSize, columnSize, min, max);
        printArray(array, rowSize, columnSize);
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                vec[i] *= Math.abs(array[i][j]);
            }
        }

        for (int i = 0; i < vec.length; i++) {
            if (vec[i] > maxValue) {
                maxValue = vec[i];
                maxIndex = i + 1;
            }
        }

        System.out.print("Rows index with the maximum product of the elements:" + maxIndex);
    }

    public static void bubbleSort(int[] unsortedArray) {
        for (int i = unsortedArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (unsortedArray[j] < unsortedArray[j + 1]) {
                    int el = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j + 1];
                    unsortedArray[j + 1] = el;
                }
            }
        }
    }

    public static void d(int rowSize, int columnSize, int min, int max) {
        int[][] array = new int[rowSize][columnSize];
        initializeArray(array, rowSize, columnSize, min, max);
        printArray(array, rowSize, columnSize);
        for (int i = 0; i < rowSize; i++) {
            bubbleSort(array[i]);
        }
        System.out.println(" ");
        printArray(array, rowSize, columnSize);
    }

    public static void main(String[] args) {
        System.out.print("a)\n");
        a(8, 8, 1, 90);
        System.out.print("\n\nb)\n");
        b(8, 5, -99, 99);
        System.out.print("\n\nc)\n");
        c(8, 5, -10, 10);
        System.out.print("\n\nd)\n");
        d(10, 7, 0, 100);
    }
}
