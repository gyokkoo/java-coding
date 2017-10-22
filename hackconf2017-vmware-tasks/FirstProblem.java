public class FirstProblem {

    public static void main(String[] args) {
        System.out.println(triangle(5));
    }

    /**
     * We have triangle made of blocks. The topmost row has 1 block,
     * the next row down has 2 blocks, the next row has 3 blocks, and so on.
     * The method compute recursively the total number of blocks in such a triangle with the given number of rows
     * @param rows The given number of rows
     * @return 0 in the bottom or
     *         rows plus recursive call
     */
    public static int triangle(int rows) {
        if (rows <= 0) {
            return 0;
        }

        return rows + triangle(rows - 1);
    }
}
