import java.util.Arrays;
import java.util.Random;

/**
 * Created by Andrey on 04.11.2016.
 */
public class Sort {

    public static void initArray(int[] array) {
        Random random = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(50);
        }
    }

    public static void arrayPrint(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void bubbleSort(int[] unsortedArray) {
        for (int i = unsortedArray.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (unsortedArray[j] > unsortedArray[j + 1]) {
                    int el = unsortedArray[j];
                    unsortedArray[j] = unsortedArray[j + 1];
                    unsortedArray[j + 1] = el;
                }
            }
        }
    }

    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int min_i = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min_i = j;
                }
            }
            if (i != min_i) {
                int tmp = arr[i];
                arr[i] = arr[min_i];
                arr[min_i] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        int[] ar1 = new int[20];
        int[] ar2 = new int[20];
        int[] ar3 = new int[20];

        initArray(ar1);
        initArray(ar2);
        initArray(ar3);

        long startTime;
        long estimatedTime;

        System.out.print("Bubble Sort" + '\n' + "Source array: ");
        arrayPrint(ar1);
        System.out.print('\n' + "Sorted array: ");
        startTime = System.nanoTime();
        bubbleSort(ar1);
        estimatedTime = System.nanoTime() - startTime;
        arrayPrint(ar1);
        System.out.print('\n' + "Work time Bubble sort: " + estimatedTime + '\n' + "Selection Sort" + '\n' + "Source array: ");
        arrayPrint(ar2);
        System.out.print('\n' + "Sorted array: ");
        startTime = System.nanoTime();
        selectionSort(ar2);
        estimatedTime = System.nanoTime() - startTime;
        arrayPrint(ar2);
        System.out.print('\n' + "Work time Selection sort: " + estimatedTime + '\n' + "Arrays Sort" + '\n' + "Source array: ");
        arrayPrint(ar3);
        System.out.print('\n' + "Sorted array: ");
        startTime = System.nanoTime();
        Arrays.sort(ar3);
        estimatedTime = System.nanoTime() - startTime;
        arrayPrint(ar3);
        System.out.print('\n' + "Work time Arrays sort: " + estimatedTime);
    }
}
