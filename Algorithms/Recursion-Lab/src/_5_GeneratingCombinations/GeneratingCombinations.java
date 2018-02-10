package _5_GeneratingCombinations;

import java.util.Scanner;

import static java.util.Arrays.stream;

public class GeneratingCombinations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] set = stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int k = Integer.parseInt(scanner.nextLine());
        int[] vector = new int[k];

        generateCombinations(set, vector, 0, 0);
    }

    private static void generateCombinations(int[] set, int[] vector, int index, int border) {
        if (index > vector.length - 1) {
            for (int element : vector) {
                System.out.print(element + " ");
            }
            System.out.println();
        } else {
            for (int i = border; i < set.length; i++) {
                vector[index] = set[i];
                generateCombinations(set, vector, index + 1, i + 1);
            }
        }
    }
}
