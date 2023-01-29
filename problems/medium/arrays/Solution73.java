package problems.medium.arrays;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/set-matrix-zeroes/
 * Time Complexity:
 * Space Complexity：
 */
class Solution73 {
    public void setZeroes(int[][] matrix) {
        boolean firstRowConsistZero = false, firstColumnConsistZero = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0) {
                        firstRowConsistZero = true;
                    }
                    if (j == 0) {
                        firstColumnConsistZero = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowConsistZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (firstColumnConsistZero) {
            Arrays.fill(matrix[0], 0);
        }
    }

    public void setZeroes1(int[][] matrix) {
        Queue<Integer> indexQueue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    indexQueue.add(i);
                    indexQueue.add(j);
                }
            }
        }

        int x, y;
        while (!indexQueue.isEmpty()) {
            x = indexQueue.poll();
            y = indexQueue.poll();
            Arrays.fill(matrix[x], 0);
            for (int j = 0; j < matrix.length; j++) {
                matrix[j][y] = 0;
            }
        }
    }
}
