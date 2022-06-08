package problems.medium;

/**
 * Problem: https://leetcode.com/problems/spiral-matrix-ii/
 * Time Complexity: O(n^2)
 * Space Complexity：
 */
class Solution59 {
    //idea from solutions
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int[] dir = {0, 1, 1, 0, 0, -1, -1, 0};
        int i = 0, j = 0;
        int d = 0;
        for (int k = 1; k <= n * n; k++) {
            res[i][j] = k;

            if (res[Math.floorMod(i + dir[d], n)][Math.floorMod(j + dir[d + 1], n)] != 0) {
                d = (d + 2) % 8;
            }
            i += dir[d];
            j += dir[d + 1];
        }
        return res;
    }

    public int[][] generateMatrix2(int n) {
        int[][] res = new int[n][n];
        int mode = 1, i = 0, j = 0;

        for (int k = 1; k <= n * n; k++) {
            if (mode == 1) {
                res[i][j] = k;
                if (j + 1 < n && res[i][j + 1] == 0) {
                    j++;
                } else {
                    mode = 2;
                    i++;
                }
            } else if (mode == 2) {
                res[i][j] = k;
                if (i + 1 < n && res[i + 1][j] == 0) {
                    i++;
                } else {
                    mode = 3;
                    j--;
                }
            } else if (mode == 3) {
                res[i][j] = k;
                if (j - 1 >= 0 && res[i][j - 1] == 0) {
                    j--;
                } else {
                    mode = 4;
                    i--;
                }
            } else {
                res[i][j] = k;
                if (i - 1 >= 0 && res[i - 1][j] == 0) {
                    i--;
                } else {
                    mode = 1;
                    j++;
                }
            }
        }

        return res;
    }
}
