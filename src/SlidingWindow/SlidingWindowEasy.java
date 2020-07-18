package SlidingWindow;

public class SlidingWindowEasy {
    public static void main(String[] args) {

    }

    /**
     * Given an array of positive numbers and a positive number ‘S’, find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists.
     * <p>
     * Example 1:
     * <p>
     * Input: [2, 1, 5, 2, 3, 2], S=7
     * Output: 2
     * Explanation: The smallest subarray with a sum great than or equal to '7' is [5, 2].
     * <p>
     * Example 2:
     * <p>
     * Input: [2, 1, 5, 2, 8], S=7
     * Output: 1
     * Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
     * <p>
     * Example 3:
     * <p>
     * Input: [3, 4, 1, 1, 6], S=8
     * Output: 3
     * Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1] or [1, 1, 6].
     * <p>
     * https://www.educative.io/courses/grokking-the-coding-interview/7XMlMEQPnnQ
     *
     * @param S
     * @param arr
     * @return
     */
    public static int findMinSubArray(int S, int[] arr) {
        int start = 0;
        int arr_size = arr.length;

        int sum = 0;
        for (int end = 0; end < arr.length; end++) {

            if (sum < S) {
                sum += arr[end];
            }
            while (sum >= S) {
                if (end - start + 1 < arr_size) {
                    arr_size = end - start + 1;
                }
                sum -= arr[start];
                start++;
            }
        }

        return arr_size;
    }
}
