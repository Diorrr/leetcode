package problems.medium.binsearch;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (binsearch(row, target)) {
                return true;
            }
        }
        return false;
    }

    private boolean binsearch(int[] row, int target) {
        int l = 0, r = row.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (row[m] == target) {
                return true;
            } else if (row[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return false;
    }


    public boolean searchMatrix1(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (Arrays.binarySearch(row, target) >= 0) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int elem : row) {
                if (elem == target) {
                    return true;
                }
            }
        }

        return false;
    }
}
