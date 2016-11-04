import java.util.Random;

/**
 * Created by Andrey on 04.11.2016.
 */
public class ControlStructures {
    enum Colors {
        White, Black, Red, Green, Blue
    }

    public static void ifElseEnum(Colors color) {

        if (color == Colors.White) {
            System.out.println();
        } else if (color == Colors.Black) {
            System.out.println();
        } else if (color == Colors.Red) {
            System.out.println();
        } else if (color == Colors.Green) {
            System.out.println();
        } else if (color == Colors.Blue) {
            System.out.println();
        }
    }

    public static void switchCaseEnum(Colors color) {
        switch (color) {
            case White: {
                System.out.println();
                break;
            }
            case Black: {
                System.out.println();
                break;
            }
            case Red: {
                System.out.println();
                break;
            }
            case Green: {
                System.out.println();
                break;
            }
            case Blue: {
                System.out.println();
                break;
            }
        }
    }

    public static void initializeArray(int[] array, int min, int max) {
        Random random = new Random(0);
        for (int i = 0; i < array.length; i++) {
            if (min >= 0)
                array[i] = Math.abs(random.nextInt() % (max + 1 - min)) + min;
            else array[i] = random.nextInt() % (max + 1);
        }
    }

    public static void ifElseArray(int[] array, int[] vec) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                System.out.print("");
                vec[0]++;
            } else if (array[i] == 1) {
                System.out.print("");
                vec[1]++;
            } else if (array[i] == 2) {
                System.out.print("");
                vec[2]++;
            } else if (array[i] == 3) {
                System.out.print("");
                vec[3]++;
            } else if (array[i] == 4) {
                System.out.print("");
                vec[4]++;
            } else if (array[i] == 5) {
                System.out.print("");
                vec[5]++;
            } else if (array[i] == 6) {
                System.out.print("");
                vec[6]++;
            } else if (array[i] == 7) {
                System.out.print("");
                vec[7]++;
            } else if (array[i] == 8) {
                System.out.print("");
                vec[8]++;
            } else if (array[i] == 9) {
                System.out.print("");
                vec[9]++;
            } else if (array[i] == 10) {
                System.out.print("");
                vec[10]++;
            }
        }
    }

    public static void switchCaseArray(int[] array, int[] vec) {
        for (int i = 0; i < array.length; i++) {
            switch (array[i]) {
                case 0: {
                    System.out.print("");
                    vec[0]++;
                    break;
                }
                case 1: {
                    System.out.print("");
                    vec[1]++;
                    break;
                }
                case 2: {
                    System.out.print("");
                    vec[2]++;
                    break;
                }
                case 3: {
                    System.out.print("");
                    vec[3]++;
                    break;
                }
                case 4: {
                    System.out.print("");
                    vec[4]++;
                    break;
                }
                case 5: {
                    System.out.print("");
                    vec[5]++;
                    break;
                }
                case 6: {
                    System.out.print("");
                    vec[6]++;
                    break;
                }
                case 7: {
                    System.out.print("");
                    vec[7]++;
                    break;
                }
                case 8: {
                    System.out.print("");
                    vec[8]++;
                    break;
                }
                case 9: {
                    System.out.print("");
                    vec[9]++;
                    break;
                }
                case 10: {
                    System.out.print("");
                    vec[10]++;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        long startTime;
        long estimatedTime;
        int[] array = new int[50];
        int[] vec1 = new int[11];
        int[] vec2 = new int[11];
        initializeArray(array, 0, 10);

        startTime = System.nanoTime();
        ifElseEnum(Colors.Blue);
        estimatedTime = System.nanoTime() - startTime;
        System.out.print("Work time enums if-else constuctions: " + estimatedTime);

        startTime = System.nanoTime();
        switchCaseEnum(Colors.Blue);
        estimatedTime = System.nanoTime() - startTime;
        System.out.print('\n' + "Work time enums switch-case constuctions: " + estimatedTime + '\n');

        startTime = System.nanoTime();
        ifElseArray(array, vec1);
        estimatedTime = System.nanoTime() - startTime;
        for (int i = 0; i < vec1.length; i++) {
            System.out.print("\nNumber of items that fall into the " + i + " branch: " + vec1[i]);
        }
        System.out.print("\n\nWork time arrays if-else constuctions: " + estimatedTime + '\n');

        startTime = System.nanoTime();
        switchCaseArray(array, vec2);
        estimatedTime = System.nanoTime() - startTime;
        for (int i = 0; i < vec2.length; i++) {
            System.out.print("\nNumber of items that fall into the " + i + " branch: " + vec2[i]);
        }
        System.out.print("\n\nWork time arrays switch-case constuctions: " + estimatedTime + '\n');
    }
}
