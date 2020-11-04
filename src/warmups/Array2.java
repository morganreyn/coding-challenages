package warmups;

public class Array2 {
    /**
     * Return a version of the given array where each zero value in the array is replaced by the largest odd value to
     * the right of the zero in the array. If there is no odd value to the right of the zero, leave the zero as a zero.
     *
     * zeroMax([0, 5, 0, 3]) → [5, 5, 3, 3]
     * zeroMax([0, 4, 0, 3]) → [3, 4, 3, 3]
     * zeroMax([0, 1, 0]) → [1, 1, 0]
     */
    public int[] zeroMax(int[] nums) {
        // Find next zero in array - replace with rightmost odd
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = maxRightOdd(nums, i + 1);
            }
        }
        return nums;
    }
    private int maxRightOdd(int[] nums, int idx) {
        int maxOdd = 0;
        for (int i = idx; i < nums.length; i++) {
            if (nums[i] > maxOdd && nums[i] % 2 == 1) {
                maxOdd = nums[i];
            }
        }
        return maxOdd;
    }
}
