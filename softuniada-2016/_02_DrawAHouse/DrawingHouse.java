package _02_DrawAHouse;

import java.util.Scanner;

public class DrawingHouse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        drawRoof(n);
        drawBase(n);
    }

    private static void drawRoof(int n) {
        int dotCount = n - 2;
        int spaceCount = 1;

        System.out.println(String.format("%s*%s",
                getNewString(".", n - 1),
                getNewString(".", n - 1)));
        for (int i = 0; i < n - 2; i++) {
            System.out.println(String.format("%s*%s*%s",
                    getNewString(".", dotCount),
                    getNewString(" ", spaceCount),
                    getNewString(".", dotCount)));
            spaceCount += 2;
            dotCount--;
        }
        System.out.println(getNewString("* ", n));
    }

    private static void drawBase(int n) {
        System.out.println(String.format("+%s+", getNewString("-", 2 * n - 3)));
        for (int i = 0; i < n - 2; i++) {
            System.out.println(String.format("|%s|", getNewString(" ", 2 * n - 3)));
        }
        System.out.println(String.format("+%s+", getNewString("-", 2 * n - 3)));
    }

    private static String getNewString(String str, int count) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < count; i++) {
            builder.append(str);
        }

        return builder.toString();
    }
}
