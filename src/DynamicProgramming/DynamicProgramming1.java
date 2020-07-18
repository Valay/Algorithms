package DynamicProgramming;

import output.OutputPrinter;

public class DynamicProgramming1 {

    public static void main(String[] args) {
        //int[][] nums = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22}};
        int[][] nums = {{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        int k = 1;

        DynamicProgramming1 dp1 = new DynamicProgramming1();
        dp1.countSquares(nums);

    }

    /**
     * Given a m * n matrix mat and an integer K, return a matrix answer where each answer[i][j] is the sum of all elements mat[r][c] for i - K <= r <= i + K, j - K <= c <= j + K, and (r, c) is a valid position in the matrix.
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
     * Output: [[12,21,16],[27,45,33],[24,39,28]]
     * Example 2:
     * <p>
     * Input: mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
     * Output: [[45,45,45],[45,45,45],[45,45,45]]
     * <p>
     * <p>
     * Constraints:
     * <p>
     * m == mat.length
     * n == mat[i].length
     * 1 <= m, n, K <= 100
     * 1 <= mat[i][j] <= 100
     * <p>
     * link - https://leetcode.com/problems/matrix-block-sum/
     *
     * @param matrix
     * @param k
     * @return
     */
    public int[][] blockSum(int[][] matrix, int k) {

        if (matrix == null || matrix.length == 0) {
            return matrix;
        }

        int m = matrix.length; // height
        int n = matrix[0].length; // width

        int[][] sum = new int[m + 1][n + 1];

        // create sum matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i + 1][j] + sum[i][j + 1] - sum[i][j] + matrix[i][j];
            }
        }

        OutputPrinter op = new OutputPrinter();
        op.print2DIntegerArray(sum);

        int[][] blockSum = new int[m][n];
        // create block sum matrix
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0, i - k);
                int r2 = Math.min(m, i + k + 1);
                int c1 = Math.max(0, j - k);
                int c2 = Math.min(n, j + k + 1);

                blockSum[i][j] = sum[r2][c2] - sum[r1][c2] - sum[r2][c1] + sum[r1][c1];
            }
        }

        op.print2DIntegerArray(blockSum);
        return blockSum;
    }

    /**
     * link - https://leetcode.com/problems/count-square-submatrices-with-all-ones/
     *
     * @param matrix
     * @return
     */
    public int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];

        int sum = 0;
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (matrix[i - 1][j - 1] >= 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                }
                sum += dp[i][j];
            }
        }

        return sum;
    }
}
