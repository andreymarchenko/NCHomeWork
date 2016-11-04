/**
 * Created by Andrey on 04.11.2016.
 */
public class DrawingShapes {

    static int size = 5;

    public static void drawRectangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j == size - 1)
                    System.out.print("#" + '\n');
                else System.out.print("# ");
            }
        }
    }

    public static void drawLeftDownTriangle() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    System.out.print("#" + '\n');
                else System.out.print("# ");
            }
        }

    }

    public static void drawLeftUpTriangle() {
        for (int i = size - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    System.out.print("#" + '\n');
                else System.out.print("# ");
            }
        }
    }

    public static void drawRightUpTriangle() {
        for (int i = size - 1; i >= 0; i--) {
            if (i < size - 1) {
                for (int y = 0; y < 2*(size-i-1) ; y++) {
                    System.out.print(" ");
                }
            }
            for (int j = 0; j <= i; j++) {
                if (j == i)
                    System.out.print("#" + '\n');
                else System.out.print("# ");
            }
        }
    }

    public static void main(String[] args) {
        drawRectangle();
        System.out.println("");
        drawLeftDownTriangle();
        System.out.println("");
        drawLeftUpTriangle();
        System.out.println("");
        drawRightUpTriangle();
    }
}
