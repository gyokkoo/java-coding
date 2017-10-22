import java.util.Arrays;

public class SecondProblem {

    public static void main(String[] args) {
        int[] array = { 2, 10, 3, 4, 20, 5 };
//        int[] array = { 10, 1, 20, 2 };
//        int[] array = { 50, 2, 9, 20, 5 };
        System.out.println(Arrays.toString(tenRun(array)));
    }

    /**
     * For each multiple of 10 in the given array changes all values following it
     * to be that multiple of 10, until encountering another multiple of 10.
     * So {2, 10, 3, 4, 20, 5} becomes {2, 10, 10, 10, 20, 20}
     * @param nums given array
     * @return the array
     */
    public static int[] tenRun(int[] nums) {
        int index = 0;
        int currentMultiple = 0;
        while (index < nums.length) {
            if (nums[index] % 10 == 0) {
                currentMultiple = nums[index];
            } else if(currentMultiple != 0) {
                nums[index] = currentMultiple;
            }
            index++;
        }

        return nums;
    }
}
