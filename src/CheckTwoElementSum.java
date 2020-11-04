import java.util.Arrays;

public class CheckTwoElementSum {
    // boolean doTwoNumbersAddUp(arr, targetSum)
    // arr  = {1,2,13,4,6,7}
    // doTwoNumbersAddUp(arr, 5) -> true
    // doTwoNumbersAddUp(arr, 7) -> true
    // doTwoNumbersAddUp(arr, 12) -> false

    public static void main(String[] args) {
        int[] array = {1, 2, 13, 4, 6, 7};
        int targetSum = 13;

        solution1(array, targetSum);
        solution2(array, targetSum);
    }

    /**
     * Nested for loop. Iterate from the front and add each subsequent element and check the sum
     * O(N^2)
     */
    public static void solution1(int[] array, int targetSum) {
        // Loop through the array starting at the first element - add other elems
        boolean result = false;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {
                int first = array[i];
                int second = array[j];
                if (first + second == targetSum) {
                    result = true;
                    break;
                }
            }
            if (result) {
                break;
            }
        }

        System.out.println(result);
    }

    /**
     * Sort the array first
     * Sort: O(N*logN)
     * Scan array: N
     * O(N*logN + N)
     */
    public static void solution2(int[] array, int targetSum) {
        // Assuming a fast sorting algorithm - O(N*logN)
        Arrays.sort(array);

        int largeIdx = array.length - 1;
        int smallIdx = 0;
        boolean result = false;

        while (largeIdx != smallIdx) {
            if (array[smallIdx] + array[largeIdx] == targetSum) {
                result = true;
                break;
            }
            if (array[smallIdx] + array[largeIdx] < targetSum) {
                smallIdx++;
            }
            else {
                largeIdx--;
            }
        }

        System.out.println(result);
    }

}
