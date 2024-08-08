package problems.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/spiral-matrix-iii">
 * spiral-matrix-iii</a>
 * Time Complexity: O(n*m)
 * Space Complexity：
 */
class Solution885 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] res = new int[rows * cols][2];
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][] visited = new boolean[rows][cols];
        visited[rStart][cStart] = true;
        res[0] = new int[]{rStart, cStart};
        int dirIndex = 0;
        int count = 1;
        int jump = 1;
        int turn = 0;
        while (count < rows * cols) {
            for (int i = 0; i < jump; i++) {
                rStart += dir[dirIndex][0];
                cStart += dir[dirIndex][1];
                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols && !visited[rStart][cStart]) {
                    visited[rStart][cStart] = true;
                    res[count][0] = rStart;
                    res[count][1] = cStart;
                    count++;
                }
            }
            turn++;
            if (turn == 2) {
                turn = 0;
                jump++;
            }
            dirIndex = (dirIndex + 1) % 4;
        }

        return res;
    }
}
