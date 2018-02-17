package _6_ConnectedAreas;

import java.util.Scanner;

public class ConnectedAreas {

    private static final char EMPTY_CELL = ' ';
    private static final char VISITED_CELL = 'V';

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

        // TODO: implement the logic!
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

    private int getRow() {
        return row;
    }

    private int getCol() {
        return col;
    }

    private int getSize() {
        return size;
    }

    @Override
    public int compareTo(Area other) {
        return Integer.compare(this.getSize(), other.getSize());
    }
}
