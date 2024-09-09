package problems.medium.arrays;

import util.ListNode;

/**
 * Problem: <a href="https://leetcode.com/problems/spiral-matrix-iv">
 * spiral-matrix-iv</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2326 {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int ind = 0;
        int currRow = 0;
        int currCol = -1;
        int[][] res = new int[m][n];
        int[][] dir = new int[][]{{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = -1;
            }
        }
        while (head != null) {
            int newRow = currRow + dir[ind][0];
            int newCol = currCol + dir[ind][1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && res[newRow][newCol] == -1) {
                res[newRow][newCol] = head.val;
                head = head.next;
                currRow = newRow;
                currCol = newCol;
            } else {
                ind = (ind + 1) % 4;
            }
        }
        return res;
    }
}
