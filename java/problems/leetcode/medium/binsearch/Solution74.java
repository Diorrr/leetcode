package problems.leetcode.medium.binsearch;

/**
 * Problem: <a href="https://leetcode.com/problems/search-a-2d-matrix">
 * search-a-2d-matrix</a>
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int k = matrix[0].length;
        int l = 0;
        int r = n * k - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            int x = m / k;
            int y = m % k;
            if (matrix[x][y] == target) {
                return true;
            }

            if (matrix[x][y] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }
}
