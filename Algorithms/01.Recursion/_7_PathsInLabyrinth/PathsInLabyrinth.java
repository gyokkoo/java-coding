package _7_PathsInLabyrinth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathsInLabyrinth {

    private static final char EXIT_SYMBOL = 'e';
    private static final char EMPTY_CELL = '-';
    private static final char WALL_CELL = '*';
    private static final char VISITED_CELL = '+';
    private static List<Character> path = new ArrayList<>();
    private static char[][] labyrinth;
    private static int ROWS;
    private static int COLUMNS;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ROWS = Integer.parseInt(scanner.nextLine());
        COLUMNS = Integer.parseInt(scanner.nextLine());
        labyrinth = new char[ROWS][COLUMNS];

        for (int i = 0; i < ROWS; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < COLUMNS; j++) {
                labyrinth[i][j] = line.charAt(j);
            }
        }

        findPaths(0, 0, 'S');
    }

    private static void findPaths(int row, int col, char direction) {
        if (!(isInBound(row, col))) {
            return;
        }

        path.add(direction);

        if (labyrinth[row][col] == EXIT_SYMBOL) {
            printPath();
        } else if (!isVisited(row, col) && isFree(row, col)) {
            labyrinth[row][col] = VISITED_CELL;
            findPaths(row, col + 1, 'R');
            findPaths(row + 1, col, 'D');
            findPaths(row, col - 1, 'L');
            findPaths(row - 1, col, 'U');
            labyrinth[row][col] = EMPTY_CELL;
        }

        path.remove(path.size() - 1);
    }

    private static boolean isInBound(int row, int col) {
        return (0 <= row && row < ROWS) && (0 <= col && col < COLUMNS);
    }

    private static boolean isFree(int row, int col) {
        return labyrinth[row][col] == EMPTY_CELL && labyrinth[row][col] != WALL_CELL;
    }

    private static boolean isVisited(int row, int col) {
        return labyrinth[row][col] == VISITED_CELL;
    }

    private static void printPath() {
        for (int i = 1; i < path.size(); i++) {
            System.out.print(path.get(i));
        }
        System.out.println();
    }
}