package _01_FirstProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        int favoriteNumber = Integer.parseInt(reader.readLine());

        boolean isOdd = false;
        boolean isNegative = false;
        boolean isGood = false;

        if (Math.abs(number) % 2 == 1) {
            isOdd = true;
        }
        if (number < 0) {
            isNegative = true;
        }
        if (Math.abs(number) % favoriteNumber == 0) {
            isGood = true;
        }

        if (!isGood && !isNegative && !isOdd) {
            System.out.println("boring");
        } else if (isGood && isNegative && isOdd) {
            System.out.println("super special awesome");
        } else if ((isGood && isNegative) || (isGood && isOdd) || (isNegative && isOdd)) {
            System.out.println("super awesome");
        } else if (isGood || isNegative || isOdd) {
            System.out.println("awesome");
        }
    }
}
