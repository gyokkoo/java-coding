package _2_NestedLoopsRecursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NestedLoops {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        printNumbers(arr, 0);
    }

    private static void printNumbers(int[] arr, int index) {
        if (index >= arr.length) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        } else {
            for (int i = 1; i <= arr.length; i++) {
                arr[index] = i;
                printNumbers(arr, index + 1);
            }
        }
    }
}
