package _1_RecursiveArraySum;

import java.util.Scanner;

import static java.util.Arrays.stream;

public class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int sum = sumWrapper(numbers);
        System.out.println(sum);
    }

    private static int sumWrapper(int[] arr) {
        return sum(arr, 0);
    }

    private static int sum(int[] arr, int index) {
        if (index > arr.length - 1) {
            return 0;
        }

        return arr[index] + sum(arr, index + 1);
    }
}
