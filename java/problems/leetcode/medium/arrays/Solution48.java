package problems.leetcode.medium.arrays;

/**
 * Problem: https://leetcode.com/problems/rotate-image/
 * Time Complexity:
 * Space Complexity：
 */
class Solution48 {
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length / 2; i++) {
            int copyLength = matrix.length - i * 2 - 2;
            int[] copy = new int[copyLength];

            int tl = matrix[i][i];
            int tr = matrix[i][matrix.length - 1 - i];
            int bl = matrix[matrix.length - 1 - i][i];
            int br = matrix[matrix.length - 1 - i][matrix.length - 1 - i];

            for (int j = 0; j < copyLength; j++) {
                copy[j] = matrix[i][i + 1 + j];
                matrix[i][i + 1 + j] = matrix[matrix.length - 1 - i - 1 - j][i];
            }

            for (int j = 0; j < copyLength; j++) {
                int t = matrix[i + 1 + j][matrix.length - 1 - i];
                matrix[i + 1 + j][matrix.length - 1 - i] = copy[j];
                copy[j] = t;
            }

            for (int j = 0; j < copyLength; j++) {
                int t = matrix[matrix.length - 1 - i][matrix.length - 1 - i - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - i - 1 - j] = copy[j];
                copy[j] = t;
            }

            for (int j = 0; j < copyLength; j++) {
                matrix[matrix.length - 1 - i - 1 - j][i] = copy[j];
            }

            matrix[i][i] = bl;
            matrix[i][matrix.length - 1 - i] = tl;
            matrix[matrix.length - 1 - i][i] = br;
            matrix[matrix.length - 1 - i][matrix.length - 1 - i] = tr;
        }
    }
}
