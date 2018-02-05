package _06_ThreeBrothers;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreeBrothers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            List<Integer> numbers = IntStream.of(Arrays.stream(scanner.nextLine().split(" ")).mapToInt
                    (Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
            boolean isPossible = checkNumbers(numbers);
            System.out.println(isPossible ? "Yes" : "No");
        }
    }

    private static boolean checkNumbers(List<Integer> numbers) {
        int totalSum = numbers.stream().mapToInt(Integer::intValue).sum();
        if (totalSum % 3 != 0) {
            return false;
        }

        int targetSum = totalSum / 3;
        boolean[][] sumReached = new boolean[targetSum + 1][targetSum + 1];
        sumReached[0][0] = true;
        for (Integer num : numbers) {
            for (int i = targetSum; i >= 0; i--) {
                for (int j = targetSum; j >= 0; j--) {
                    if (sumReached[i][j]) {
                        if (i + num <= targetSum && !sumReached[i + num][j]) {
                            sumReached[i + num][j] = true;
                        }
                        if (j + num <= targetSum && !sumReached[i][j + num]) {
                            sumReached[i][j + num] = true;
                        }
                    }
                }
            }
        }

        return sumReached[targetSum][targetSum];
    }
}