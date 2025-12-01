package problems.leetcode.easy.array;

/**
 * Problem: https://leetcode.com/problems/convert-1d-array-into-2d-array/
 * Time Complexity: O(n*m)
 * Space Complexity： O(n*m)
 */
class Solution2022 {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original.length != m * n) {
            return new int[0][0];
        } else {
            int[][] res = new int[m][n];
            for (int i = 0; i < m; i++) {
                if (n >= 0) System.arraycopy(original, i * n, res[i], 0, n);
            }

            return res;
        }
    }
}
