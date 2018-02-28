package _3_CombinationsWithRepetition;

import java.util.Scanner;

public class GenerateCombinations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        int[] set = new int[k];

        generateCombinations(set, n, 1, 0);

    }

    private static void generateCombinations(int[] set, int n, int start, int index) {
        if (index >= set.length) {
            for (int num : set) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= n; i++) {
            set[index] = i;
            generateCombinations(set, n, i, index + 1);
        }
    }
}
