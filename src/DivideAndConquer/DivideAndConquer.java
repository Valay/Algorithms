package DivideAndConquer;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class DivideAndConquer {


    /**
     * https://leetcode.com/problems/majority-element/
     * <p>
     * Algorithm - https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {

        int maxElement = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                maxElement = nums[i];
                count++;
            } else if (maxElement == nums[i]) {
                count++;
            } else {
                count--;
            }
        }

        if (count < 0) {
            return -1;
        }

        return maxElement;
    }

    public static void main(String[] args) {

        DivideAndConquer dc = new DivideAndConquer();
        int[][] nums = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}};
        int k = 5;

        System.out.println(dc.searchMatrixLinear(nums, k));

    }

    /**
     * https://leetcode.com/problems/maximum-subarray/submissions/
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {

        int maxSum = nums[0];
        int maxStart = 0;
        int maxEnd = 0;

        int curMax = nums[0];
        int curStart = 0;
        int curEnd = 0;

        for (int i = 1; i < nums.length; i++) {
            if (curMax < 0 && nums[i] > curMax) {
                curMax = nums[i];
                curStart = i;
                curEnd = i;
            } else {
                curMax = curMax + nums[i];
                curEnd = i;
            }

            if (curMax > maxSum) {
                maxSum = curMax;
                maxStart = curStart;
                maxEnd = curEnd;
            }
        }

        return maxSum;

    }

    /**
     * Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.
     * <p>
     * Example 1:
     * <p>
     * Input: "2-1-1"
     * Output: [0, 2]
     * Explanation:
     * ((2-1)-1) = 0
     * (2-(1-1)) = 2
     * Example 2:
     * <p>
     * Input: "2*3-4*5"
     * Output: [-34, -14, -10, -10, 10]
     * Explanation:
     * (2*(3-(4*5))) = -34
     * ((2*3)-(4*5)) = -14
     * ((2*(3-4))*5) = -10
     * (2*((3-4)*5)) = -10
     * (((2*3)-4)*5) = 10
     * <p>
     * Link - https://leetcode.com/problems/different-ways-to-add-parentheses/
     *
     * @param input
     * @return
     */
    public List<Integer> diffWaysToCompute(String input) {
        if (input.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> sum = new ArrayList<>();

        boolean isExpression = false;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if (isOperator(c)) {
                isExpression = true;
                List<Integer> sumLeft = diffWaysToCompute(input.substring(0, i));
                List<Integer> sumRight = diffWaysToCompute(input.substring(i + 1, input.length()));

                for (Integer a : sumLeft) {
                    for (Integer b : sumRight) {
                        sum.add(compute(a, b, c));
                    }
                }
            }
        }

        if (!isExpression) {
            sum.add(Integer.parseInt(input));
        }

        return sum;

    }

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     * <p>
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * <p>
     * link - https://leetcode.com/problems/kth-largest-element-in-an-array/
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) { // see next method for better solution
        Queue<Integer> maxHeap = new PriorityQueue<Integer>(k);

        for (int num : nums) {
            if (maxHeap.size() < k) {
                maxHeap.add(num);
                continue;
            }

            if (maxHeap.peek() < num) {
                maxHeap.poll();
                maxHeap.add(num);
            }
        }

        return maxHeap.poll();
    }

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.
     * <p>
     * Example 1:
     * <p>
     * Input: [3,2,1,5,6,4] and k = 2
     * Output: 5
     * Example 2:
     * <p>
     * Input: [3,2,3,1,2,4,5,5,6] and k = 4
     * Output: 4
     * <p>
     * link - https://leetcode.com/problems/kth-largest-element-in-an-array/
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargestQuickSelect(int[] nums, int k) {
        throw new UnsupportedOperationException();
    }

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * Example:
     * <p>
     * Consider the following matrix:
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * Given target = 5, return true.
     * <p>
     * Given target = 20, return false.
     * <p>
     * <p>
     * Link - https://leetcode.com/problems/search-a-2d-matrix-ii/
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) { // see another solution below O(logm + logn)

        if (matrix.length == 0) {
            return false;
        }

        int left = 0, right = matrix.length - 1;
        int top = 0, bottom = matrix[0].length - 1;

        return searchMatrix(matrix, left, right, top, bottom, target);
    }

    private boolean searchMatrix(int[][] matrix, int left, int right,
                                 int top, int bottom, int target) {

        if (left <= right && top <= bottom) {

            int rowMid = (left + right) / 2;
            int colMid = (top + bottom) / 2;

            int midElement = matrix[rowMid][colMid];

            if (target > midElement) {
                return searchMatrix(matrix, rowMid + 1, right, top, bottom, target)
                        || searchMatrix(matrix, left, right, colMid + 1, bottom, target);
            } else if (target < midElement) {
                return searchMatrix(matrix, left, rowMid - 1, top, bottom, target)
                        || searchMatrix(matrix, left, right, top, colMid - 1, target);
            } else {
                return true;
            }
        }

        return false;
    }

    // https://leetcode.com/problems/search-a-2d-matrix-ii/
    public boolean searchMatrixLinear(int[][] matrix, int target) { // O(m+n)

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col > 0) {
            int element = matrix[row][col];
            if (target < element) {
                col--;
            } else if (target > element) {
                row++;
            } else {
                return true;
            }
        }

        return false;
    }


    // --------------------------- ALL Utility Methods --------------------------------------- //

    private int compute(int a, int b, Character c) {
        switch (c) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new RuntimeException("IllegalArgument");
        }

    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*';
    }


}
