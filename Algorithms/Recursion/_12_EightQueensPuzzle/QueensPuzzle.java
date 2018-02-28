package _6_EightQueensPuzzle;

public class QueensPuzzle {

    public static void main(String[] args) {
        EightQueens queens = new EightQueens();
        queens.putQueens(0);
        //System.out.println(queens.getSolutionsFound());
    }
}

class EightQueens {
    private static final char QUEENS_SYMBOL = '*';
    private static final char CELL_SYMBOL = '-';
    private static final int SIZE = 8;
    private boolean [][] chessboard;
    private boolean [] attackedColumns;
    private boolean [] attackedLeftDiagonals;
    private boolean [] attackedRightDiagonals;
    private int solutionsFound;

    public EightQueens() {
        this.chessboard = new boolean[SIZE][SIZE];
        this.attackedColumns = new boolean[SIZE];
        this.attackedLeftDiagonals = new boolean[2 * SIZE];
        this.attackedRightDiagonals = new boolean[2 * SIZE];
        this.solutionsFound = 0;
    }

    public void putQueens(int row) {
        if (row == SIZE) {
            this.solutionsFound++;
            printSolution();
        } else {
            for (int col = 0; col < SIZE; col++) {
                if (canPlaceQueen(row, col)) {
                    markAttackedPositions(row, col);
                    putQueens(row + 1);
                    unmarkAttackedPositions(row, col);
                }
            }
        }
    }

    public int getSolutionsFound() {
        return this.solutionsFound;
    }

    private void markAttackedPositions(int row, int col) {
        this.attackedColumns[col] = true;
        this.attackedLeftDiagonals[7 + row - col] = true;
        this.attackedRightDiagonals[row + col] = true;
        this.chessboard[row][col] = true;
    }

    private void unmarkAttackedPositions(int row, int col) {
        this.attackedColumns[col] = false;
        this.attackedLeftDiagonals[7 + row - col] = false;
        this.attackedRightDiagonals[row + col] = false;
        this.chessboard[row][col] = false;
    }

    private boolean canPlaceQueen(int row, int col) {
        boolean isOccupied =
                this.attackedColumns[col] ||
                this.attackedLeftDiagonals[7 + row - col] ||
                this.attackedRightDiagonals[row + col];

        return !isOccupied;
    }

    private void printSolution() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                System.out.print((chessboard[row][col] ? QUEENS_SYMBOL : CELL_SYMBOL) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
