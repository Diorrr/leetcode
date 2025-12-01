package problems.leetcode.medium.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/maximal-square">
 * maximal-square</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution221 {
    public int maximalSquare(char[][] matrix) {
        int res = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            dp[i][0] = matrix[i][0] - '0';
            res = Math.max(dp[i][0], res);
        }
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = matrix[0][i] - '0';
            res = Math.max(dp[0][i], res);
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res * res;
    }

    public int maximalSquare2(char[][] matrix) {
        int[][] sum = new int[matrix.length][matrix[0].length];
        int res = 0;
        sum[0][0] = matrix[0][0] - '0';
        for (int i = 1; i < matrix.length; i++) {
            sum[i][0] += matrix[i][0] - '0' + sum[i - 1][0];
        }
        for (int i = 1; i < matrix[0].length; i++) {
            sum[0][i] += matrix[0][i] - '0' + sum[0][i - 1];
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                sum[i][j] += matrix[i][j] - '0' + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int len = Math.max(matrix.length - 1 - i, matrix[0].length - 1 - j); len >= 0; len--) {
                    int currSum = sum[i + len][j + len];
                    if (j > 0) {
                        currSum -= sum[i + len][j - 1];
                    }
                    if (i > 0) {
                        currSum -= sum[i - 1][j + len];
                    }
                    if (i > 0 && j > 0) {
                        currSum += sum[i - 1][j - 1];
                    }
                    if (currSum == (len + 1) * (len + 1)) {
                        res = Math.max(res, len + 1);
                        break;
                    }
                }
            }
        }

        return res * res;
    }
}
