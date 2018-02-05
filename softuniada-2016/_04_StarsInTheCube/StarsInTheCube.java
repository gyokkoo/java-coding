package _04_StarsInTheCube;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class StarsInTheCube {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Character[][][] cube = new Character[n][n][n];
        for (int i = 0; i < n; i++) {
            String[] rows = reader.readLine().split("\\|");
            for (int j = 0; j < rows.length; j++) {
                String[] letters = rows[j].trim().split(" ");
                for (int k = 0; k < letters.length; k++) {
                    cube[i][j][k] = letters[k].toCharArray()[0];
                }
            }
        }

        SortedMap<Character, Integer> charactersCount = new TreeMap<>();
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                for (int k = 1; k < n - 1; k++) {
                    if (checkStar(cube, i, j, k)) {
                        if (!charactersCount.containsKey(cube[i][j][k])) {
                            charactersCount.put(cube[i][j][k], 0);
                        }
                        int newCount = charactersCount.get(cube[i][j][k]) + 1;
                        charactersCount.put(cube[i][j][k], newCount);
                    }
                }
            }
        }

        System.out.println(charactersCount.entrySet().stream().mapToInt(Map.Entry::getValue).sum());
        for (Map.Entry<Character, Integer> entry : charactersCount.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }

    private static boolean checkStar(Character[][][] cube, int i, int j, int k) {
        return cube[i][j][k] == cube[i - 1][j][k] &&
                cube[i][j][k] == cube[i][j - 1][k] &&
                cube[i][j][k] == cube[i][j][k - 1] &&
                cube[i][j][k] == cube[i + 1][j][k] &&
                cube[i][j][k] == cube[i][j + 1][k] &&
                cube[i][j][k] == cube[i][j][k + 1];
    }
}
