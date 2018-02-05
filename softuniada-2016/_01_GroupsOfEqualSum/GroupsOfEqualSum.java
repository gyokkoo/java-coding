package _01_GroupsOfEqualSum;

import java.util.Scanner;

public class GroupsOfEqualSum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int thirdNumber = scanner.nextInt();
        int fourthNumber = scanner.nextInt();

        int halfSum = (firstNumber + secondNumber + thirdNumber + fourthNumber) / 2;
        if (canBeSplit(firstNumber, secondNumber, thirdNumber, fourthNumber)) {
            System.out.println("Yes");
            System.out.println(halfSum);
        } else {
            System.out.println("No");
        }
    }

    private static boolean canBeSplit(int a, int b, int c, int d) {
        return a == b + c + d ||
                b == a + c + d ||
                c == a + b + d ||
                d == a + b + c ||
                a + b == c + d ||
                a + c == b + d ||
                a + d == b + c;
    }
}