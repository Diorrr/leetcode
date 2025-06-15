package problems.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/maximum-matrix-sum">
 * maximum-matrix-sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1975 {
    public long maxMatrixSum(int[][] matrix) {
        long res = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem < 0) {
                    count++;
                    elem = -elem;
                }
                res += elem;
                min = Math.min(elem, min);
            }
        }

        return count % 2 == 0 ? res : res - 2L * min;
    }
}
