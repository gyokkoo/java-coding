package _1_ReverseArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ReverseArray {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays
                .stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        printReversed(numbers, numbers.length - 1);
    }

    private static void printReversed(int[] numbers, int index) {
        if (index < 0) {
            return;
        }

        System.out.print(numbers[index] + " ");
        printReversed(numbers, index - 1);
    }
}
