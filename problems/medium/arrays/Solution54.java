package problems.medium.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/spiral-matrix/
 * Time Complexity: O(m*n)
 * Space Complexity：
 */
class Solution54 {
    public List<Integer> spiralOrder(int[][] matrix) {
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
