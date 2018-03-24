package _04_FourthProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        Integer[][][] matrix = new Integer[n][n][n];
        Integer[][][] copyMatrix = new Integer[n][n][n];

        for (int i = 0; i < n; i++) {
            String[] rows = reader.readLine().split("\\|");
            for (int j = 0; j < n; j++) {
                String[] numbers = rows[j].trim().split(" ");
                for (int k = 0; k < n; k++) {
                    matrix[i][j][k] = Integer.parseInt(numbers[k]);
                    copyMatrix[i][j][k] = Integer.parseInt(numbers[k]);
                }
            }
        }
        String[] coordinates = reader.readLine().split(" ");
        int x = Integer.parseInt(coordinates[1]);
        int y = Integer.parseInt(coordinates[0]);
        int z = Integer.parseInt(coordinates[2]);
        int wrongNumber = matrix[x][y][z];


        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (matrix[i][j][k] == wrongNumber) {
                        fixMatrix(matrix, copyMatrix, i, j, k, n);
                        count++;
                    }
                }
            }
        }

        System.out.println("Wrong values found and replaced: " + count);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    System.out.print(copyMatrix[j][i][k] + " ");
                }
                System.out.println();
            }
        }
    }

    private static void fixMatrix(Integer[][][] matrix, Integer[][][] matrix2, int i, int j, int k, int n) {
        int wrongNumber = matrix[i][j][k];
        int sum = 0;
        if (i + 1 < n)
            if (matrix[i + 1][j][k] != wrongNumber)
                sum += matrix[i + 1][j][k];

        if (j + 1 < n)
            if (matrix[i][j + 1][k] != wrongNumber)
                sum += matrix[i][j + 1][k];

        if (k + 1 < n)
            if (matrix[i][j][k + 1] != wrongNumber)
                sum += matrix[i][j][k + 1];

        if (i - 1 >= 0)
            if (matrix[i - 1][j][k] != wrongNumber)
                sum += matrix[i - 1][j][k];

        if (j - 1 >= 0)
            if (matrix[i][j - 1][k] != wrongNumber)
                sum += matrix[i][j - 1][k];

        if (k - 1 >= 0)
            if (matrix[i][j][k - 1] != wrongNumber)
                sum += matrix[i][j][k - 1];

        matrix2[i][j][k] = sum;
    }
}
