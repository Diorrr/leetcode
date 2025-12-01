package problems.leetcode.medium.arrays;

/**
 * Problem: https://leetcode.com/problems/where-will-the-ball-fall/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1706 {
    public int[] findBall(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] answer = new int[n];
        for (int idx = 0; idx < answer.length; idx++) {
            int x = 0, y = idx;
            while (answer[idx] == 0) {
                if (grid[x][y] == 1) {
                    if (y + 1 >= n) {
                        answer[idx] = -1;
                    } else if (grid[x][y + 1] == -1) {
                        answer[idx] = -1;
                    } else if (x + 1 >= m) {
                        answer[idx] = y + 1;
                        break;
                    } else {
                        x++;
                        y++;
                    }
                } else {
                    if (y == 0) {
                        answer[idx] = -1;
                    } else if (grid[x][y - 1] == 1) {
                        answer[idx] = -1;
                    } else if (x + 1 >= m) {
                        answer[idx] = y - 1;
                        break;
                    } else {
                        x++;
                        y--;
                    }
                }
            }
        }

        return answer;
    }
}
