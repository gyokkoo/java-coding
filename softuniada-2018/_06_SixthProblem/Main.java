package _06_SixthProblem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class ConnectedAreas {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while(!line.equals("end")) {
            TreeMap<Integer, Integer> areaMap = new TreeMap(Collections.reverseOrder());
            String[] dimension = line.split("x");
            int x = Integer.parseInt(dimension[0]);
            int y = Integer.parseInt(dimension[1]);
            Integer[][] matrix = new Integer[x][y];
            for (int i = 0; i < x; i++) {
                line = reader.readLine();
                for (int j = 0; j < line.length(); j++) {
                    matrix[i][j] = Integer.parseInt(Character.toString(line.charAt(j)));
                }
            }

            int[] coordinates = new int[2];
            coordinates[0] = x;
            coordinates[1]= y;
            while (findFirstUnvisited(matrix, coordinates)) {
                int startRow = coordinates[0];
                int startCol = coordinates[1];
                Area area = new Area(0);
                traverseArea(matrix, area, startRow, startCol);
                int key =area.getSize();
                if (!areaMap.containsKey(key)) {
                    areaMap.put(key, 0);
                }
                areaMap.put(key, areaMap.get(key) + 1);
            }

            int total = 0;
            for (Map.Entry<Integer, Integer> entry : areaMap.entrySet()) {
                System.out.println(entry.getValue()+ "x" +entry.getKey());
                total += entry.getValue();
            }
            System.out.println("Total: " + total);

            line = reader.readLine();
        }
    }

    private static void traverseArea(Integer[][] matrix, Area area, int row, int col) {
        if (!isInRange(matrix, row, col)) {
            return;
        }

        if (matrix[row][col] != 1) {
            return;
        }

        matrix[row][col]= 3;
        area.incrementSize();
        traverseArea(matrix, area, row - 1, col);
        traverseArea(matrix, area, row, col - 1);
        traverseArea(matrix, area, row + 1, col);
        traverseArea(matrix, area, row, col + 1);
    }

    private static boolean isInRange(Integer[][] matrix, int row, int col) {
        boolean isRowInRange = 0 <= row && row < matrix.length;
        boolean isColumnInRange = 0 <= col && col < matrix[0].length;
        return isRowInRange && isColumnInRange;
    }

    private static boolean findFirstUnvisited(Integer[][] matrix, int[] coordinates) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 1) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    return true;
                }
            }
        }

        return false;
    }
}

class Area  {
    private int size;

    public Area(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void incrementSize() {
        this.size += 1;
    }
}
