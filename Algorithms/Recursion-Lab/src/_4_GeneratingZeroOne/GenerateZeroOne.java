package _4_GeneratingZeroOne;

import java.util.Scanner;

public class GenerateZeroOne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[] vector = new int[n];
        int index = 0;

        generate(vector, index);
    }

    private static void generate(int[] vector, int index) {
        if (index > vector.length - 1) {
            for (int element : vector) {
                System.out.print(element);
            }
            System.out.println();
        }
        else {

            for (int i = 0; i <= 1; i++) {
                vector[index] = i;
                generate(vector, index + 1);
            }
        }
    }
}
