package problems.medium.sim;


/**
 * Problem: <a href="https://leetcode.com/problems/count-unguarded-cells-in-the-grid">
 * count-unguarded-cells-in-the-grid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2257 {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};
        int res = 0;
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        for (int[] guard : guards) {
            for (int i = 0; i < dir.length; i += 2) {
                int x = guard[0];
                int y = guard[1];
                int newX = x + dir[i];
                int newY = y + dir[i + 1];
                while (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                    if (grid[newX][newY] > 0) {
                        break;
                    } else {
                        grid[newX][newY] = -1;
                    }
                    newX += dir[i];
                    newY += dir[i + 1];
                }
            }
        }

        for (int[] row : grid) {
            for (int elem : row) {
                res += elem == 0 ? 1 : 0;
            }
        }
        return res;
    }
}
