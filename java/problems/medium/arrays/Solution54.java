package problems.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/spiral-matrix/
 * Time Complexity: O(m*n)
 * Space Complexity：
 */
class Solution54 {
    // 1100 is (not) magic number which is out of matrix range
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int[] dir = {0, 1, 1, 0, 0, -1, -1, 0};
        int i = 0, j = 0;
        int m = matrix.length, n = matrix[0].length;
        int d = 0;
        for (int k = 1; k <= m * n; k++) {
            res.add(matrix[i][j]);
            matrix[i][j] = 1100;
            if (matrix[Math.floorMod(i + dir[d], m)][Math.floorMod(j + dir[d + 1], n)] == 1100) {
                d = (d + 2) % 8;
            }
            i += dir[d];
            j += dir[d + 1];
        }
        return res;
    }

    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int borderRight = n - 1, borderBottom = m - 1, borderLeft = 0, borderUp = 0;
        if (m == 1 || n == 1) {
            for (int[] ints : matrix) {
                for (int j = 0; j < matrix[0].length; j++) {
                    res.add(ints[j]);
                }
            }
            return res;
        }

        while (res.size() != m * n) {
            if (borderLeft == borderRight && borderUp == borderBottom) {
                res.add(matrix[borderLeft][borderUp]);
                return res;
            } else if (borderLeft == borderRight) {
                for (int i = borderUp; i <= borderBottom; i++) {
                    res.add(matrix[i][borderLeft]);
                }
                return res;
            } else if (borderUp == borderBottom) {
                for (int i = borderLeft; i <= borderRight; i++) {
                    res.add(matrix[borderUp][i]);
                }
                return res;
            }

            for (int i = borderLeft; i < borderRight; i++) {
                res.add(matrix[borderUp][i]);
            }

            for (int i = borderUp; i < borderBottom; i++) {
                res.add(matrix[i][borderRight]);
            }

            for (int i = borderRight; i > borderLeft; i--) {
                res.add(matrix[borderBottom][i]);
            }

            for (int i = borderBottom; i > borderUp; i--) {
                res.add(matrix[i][borderLeft]);
            }

            borderUp++;
            borderRight--;
            borderBottom--;
            borderLeft++;
        }

        return res;
    }
}
