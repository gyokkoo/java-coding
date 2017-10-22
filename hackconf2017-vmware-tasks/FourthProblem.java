public class FourthProblem {

    public static void main(String[] args) {
        int[] array = {15, 6, 115, 99, 13, 5, 6};
        System.out.println(sameEnds(array, 2));
    }


    /**
     * Return true if the group of N numbers at the start and end of the array are the same.
     * For example, with {5, 6, 45, 99, 13, 5, 6}, the ends are the same for n=0 and n=2
     * and false for n=1 and n=3.
     * @param nums Array of numbers
     * @param len the length of target array
     * @return
     */
    public static boolean sameEnds(int[] nums, int len) {
        int firstElement = nums[0];
        int lastElement = nums[len];
        boolean isSameEnds = false;
        while (lastElement > 0) {
            if (firstElement == lastElement ) {
                isSameEnds = true;
                break;
            }

            if (lastElement > 10) {
                lastElement = Integer.parseInt(
                        Integer.toString(lastElement).substring(1));
            } else {
                break;
            }
        }

        return isSameEnds;
    }
}
