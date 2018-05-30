package recursionStaircaseProblem;

import java.util.Scanner;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static int countPathMemo(int steps) {
        if (steps < 0) {
            return 0;
        }
        return countPathsMemo(steps, new int[steps + 1]);
    }

    private static int countPathsMemo(int steps, int[] memo) {
        if (steps < 0) {
            return 0;
        }
        if (steps == 0) {
            return 1;
        }

        if (memo[steps] == 0) {
            memo[steps] = countPathsMemo(steps - 1, memo)
                    + countPathsMemo(steps - 2, memo)
                    + countPathsMemo(steps - 3, memo);
        }

        return memo[steps];
    }

    private static int countPathsDP(int steps) {
        if (steps < 0) {
            return 0;
        }
        if (steps <= 1) {
            return 1;
        }
        int[] paths = new int[steps + 1];
        paths[0] = 1;
        paths[1] = 1;
        paths[2] = 2;
        for (int i = 3; i <= steps; i++) {
            paths[i] = paths[i - 1] + paths[i - 2] + paths[i - 3];
        }

        return paths[steps];
    }

    private static int countPathsIterative(int steps) {
        if (steps < 0) {
            return 0;
        }
        if (steps <= 1) {
            return 1;
        }
        int[] paths = {1, 1, 2};
        for (int i = 3; i <= steps; i++) {
            int newCount = paths[0] + paths[1] + paths[2];
            paths[0] = paths[1];
            paths[1] = paths[2];
            paths[2] = newCount;
        }

        return paths[2];
    }

    public static void main(String[] args) {
        int s = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int sItr = 0; sItr < s; sItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            int result = countPathsIterative(n);
            // int result = countPathMemo(n);
            // int result = countPathsDP(n);

            System.out.println(result);
        }

        scanner.close();
    }
}
