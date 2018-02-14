package _6_EightQueensPuzzlePermutation;

public class EightQueens {

    private static final int SIZE = 8;
    private static final char QUEENS_SYMBOL = '*';
    private static final char CELL_SYMBOL = '-';

    public static void main(String[] args) {
        int[] arr = new int[SIZE];
        findSolutions(arr, 0);
    }

    private static void findSolutions(int[] arr, int k) {
        if (k == SIZE) {
            print(arr);
        } else {
            for (int i = 0; i < arr.length; i++) {
                arr[k] = i;
                if (isConsistent(arr, k)) {
                    findSolutions(arr, k + 1);
                }
            }
        }
    }

    private static boolean isConsistent(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            // same column
            if (arr[i] == arr[k])
                return false;

            // same right diagonal
            if (arr[i] - arr[k] == (k - i))
                return false;

            // same left diagonal
            if (arr[k] - arr[i] == k - i)
                return false;
        }
        return true;
    }

    private static void print(int[] arr) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (arr[i] == j) {
                    System.out.print(QUEENS_SYMBOL + " ");
                } else {
                    System.out.print(CELL_SYMBOL + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}