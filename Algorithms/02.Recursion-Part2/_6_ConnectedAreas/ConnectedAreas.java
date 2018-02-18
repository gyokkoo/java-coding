package _6_ConnectedAreas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ConnectedAreas {

    private static final char EMPTY_CELL = '-';
    private static final char VISITED_CELL = '*';

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        ArrayList<Area> areas = new ArrayList<>();
        int[] coordinates = new int[2];
        while (findFirstUnvisited(matrix, coordinates)) {
            int startRow = coordinates[0];
            int startCol = coordinates[1];
            Area area = new Area(startRow, startCol, 0);
            traverseArea(matrix, area, startRow, startCol);
            areas.add(area);
        }

        Collections.sort(areas);
        System.out.println("Total areas found: " + areas.size());
        int areaNumber = 1;
        for (Area area : areas) {
            System.out.printf("Area #%d at (%d, %d), size: %d%n",
                    areaNumber, area.getRow(), area.getCol(), area.getSize());
            areaNumber++;

        }

    }

    private static void traverseArea(char[][] matrix, Area area, int row, int col) {
        if (!isInRange(matrix, row, col)) {
            return;
        }

        if (matrix[row][col] != EMPTY_CELL) {
            return;
        }

        matrix[row][col]= VISITED_CELL;
        area.incrementSize();
        traverseArea(matrix, area, row - 1, col);
        traverseArea(matrix, area, row, col - 1);
        traverseArea(matrix, area, row + 1, col);
        traverseArea(matrix, area, row, col + 1);
    }

    private static boolean isInRange(char[][] matrix, int row, int col) {
        boolean isRowInRange = 0 <= row && row < matrix.length;
        boolean isColumnInRange = 0 <= col && col < matrix[0].length;
        return isRowInRange && isColumnInRange;
    }

    private static boolean findFirstUnvisited(char[][] matrix, int[] coordinates) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == EMPTY_CELL) {
                    coordinates[0] = row;
                    coordinates[1] = col;
                    return true;
                }
            }
        }

        return false;
    }
}

class Area implements Comparable<Area> {
    private int row;
    private int col;
    private int size;

    public Area(int startRow, int startCol, int size) {
        this.row = startRow;
        this.col = startCol;
        this.size = size;
    }
    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getSize() {
        return size;
    }

    public void incrementSize() {
        this.size += 1;
    }

    @Override
    public int compareTo(Area other) {
        return Integer.compare(other.getSize(), this.getSize());
    }
}