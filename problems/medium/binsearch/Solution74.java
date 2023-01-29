package problems.medium.binsearch;

/**
 * Problem: https://leetcode.com/problems/search-a-2d-matrix/
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || (matrix.length == 1 && matrix[0].length == 0)) {
            return false;
        } else if (matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }
        int n = matrix.length, k = matrix[0].length, m;
        int l = 0, r = n * k, m1, m2;
        while (l < r - 1) {
            m = (l + r) / 2;
            m1 = m / k;
            m2 = m % k;
            if (matrix[m1][m2] == target) {
                return true;
            }

            if (matrix[m1][m2] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        m = (l + r) / 2;
        m1 = m / k;
        m2 = m % k;

        return matrix[m1][m2] == target;
    }
}
