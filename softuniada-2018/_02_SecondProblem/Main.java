package _02_SecondProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
//        int n = 8;
        int dotsCount = (5 * n - n) / 2;
        System.out.print(newString(dotsCount, '.'));
        System.out.print(newString(n, '*'));
        System.out.println(newString(dotsCount, '.'));

        int plusCount = n;
        int asterixCount = 0;
        for (int i = 0; i < n / 2; i++) {
            dotsCount-=2;
            asterixCount++;
            plusCount+=2;
            System.out.print(newString(dotsCount, '.'));
            System.out.print(newString(asterixCount, '*')
                    + newString(plusCount, '+') + newString(asterixCount, '*'));
            System.out.print(newString(dotsCount, '.'));
            System.out.println();
        }

        int equalCount = 5*n - 2*(n + 1) - 2;
        for (int i = 0; i < n / 2; i++) {
            equalCount += 2;
            dotsCount-=1;
            System.out.print(newString(dotsCount, '.'));
            System.out.print("**" + newString(equalCount, '=') + "**");
            System.out.print(newString(dotsCount, '.'));
            System.out.println();
        }

        System.out.println(newString(dotsCount, '.') + "**" +
                        newString((equalCount - "HAPPY EASTER".length()) / 2, '~') + "HAPPY EASTER"
                        + newString((equalCount - "HAPPY EASTER".length()) / 2, '~')
                        + "**" +newString(dotsCount, '.'));

        for (int i = 0; i < n / 2; i++) {
            System.out.print(newString(dotsCount, '.'));
            System.out.print("**" + newString(equalCount, '=') + "**");
            System.out.print(newString(dotsCount, '.'));
            System.out.println();
            equalCount -= 2;
            dotsCount+=1;
        }
        for (int i = 0; i < n / 2; i++) {

            System.out.print(newString(dotsCount, '.'));
            System.out.print(newString(asterixCount, '*')
                    + newString(plusCount, '+') + newString(asterixCount, '*'));
            System.out.print(newString(dotsCount, '.'));
            System.out.println();
            dotsCount+=2;
            asterixCount--;
            plusCount-=2;
        }

        System.out.print(newString((5 * n - n) / 2, '.'));
        System.out.print(newString(n, '*'));
        System.out.println(newString((5 * n - n) / 2, '.'));
    }

    private static String newString(int n, char symbol) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(symbol);
        }
        return builder.toString();
    }
}
