package problems.leetcode.easy.array;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-degree-of-each-vertex">
 * find-the-degree-of-each-vertex</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3898 {
    public int[] findDegrees(int[][] matrix) {
        int[] res = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                res[i] += matrix[i][j];
            }
        }
        return res;
    }

    public int[] findDegrees1(int[][] matrix) {
        int[] res = new int[matrix.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = Arrays.stream(matrix[i]).sum();
        }
        return res;
    }
}
