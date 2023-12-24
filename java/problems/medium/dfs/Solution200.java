package problems.medium.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/number-of-islands">
 * number-of-islands</a>
 * Time Complexity: O(n*m)
 * Space Complexity： O(1)
 */
class Solution200 {
    int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};

    public class UnionFind {
        private int[] parent;
        int count;

        public UnionFind(char[][] grid) {
            parent = new int[grid.length * grid[0].length];
            count = 0;
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    if (grid[i][j] == '1') {
                        parent[i * grid[0].length + j] = i * grid[0].length + j;
                        count++;
                    }
                }
            }
        }

        public int find(int i) {
            if (parent[i] == i) {
                return i;
            }
            parent[i] = find(parent[i]);
            return parent[i];
        }

        public void union(int i, int j) {
            int irep = find(i);
            int jrep = find(j);

            if (irep != jrep) {
                parent[irep] = jrep;
                count--;
            }
        }
    }

    public int numIslands(char[][] grid) {
        UnionFind unionFind = new UnionFind(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    for (int k = 0; k < dir.length; k += 2) {
                        int newX = i + dir[k], newY = j + dir[k + 1];
                        if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                            unionFind.union(i * grid[0].length + j, (i + dir[k]) * grid[0].length + j + dir[k + 1]);
                        }
                    }
                }
            }
        }

        return unionFind.count;
    }

    // sol from comments
    public int numIslands1(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    delete(i, j, grid);
                    res++;
                }
            }
        }

        return res;
    }

    private void delete(int i, int j, char[][] grid) {
        grid[i][j] = '0';
        if (i > 0 && grid[i - 1][j] == '1') {
            delete(i - 1, j, grid);
        }
        if (j > 0 && grid[i][j - 1] == '1') {
            delete(i, j - 1, grid);
        }
        if (i + 1 < grid.length && grid[i + 1][j] == '1') {
            delete(i + 1, j, grid);
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == '1') {
            delete(i, j + 1, grid);
        }

    }

    public int numIslands2(char[][] grid) {
        int res = 0;
        int[][] used = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && used[i][j] == 0) {
                    dfs(i, j, used, grid);
                    res++;
                }
            }
        }

        return res;
    }

    private void dfs(int i, int j, int[][] used, char[][] grid) {
        used[i][j] = 1;
        for (int k = 0; k < dir.length; k += 2) {
            int newX = i + dir[k], newY = j + dir[k + 1];
            if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                if (used[newX][newY] == 0 && grid[newX][newY] == '1') {
                    dfs(newX, newY, used, grid);
                }
            }
        }
    }

    private void bfs(int i, int j, int[][] used, char[][] grid) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        queue.add(j);
        used[i][j] = 1;
        while (!queue.isEmpty()) {
            int x = queue.remove(), y = queue.remove();
            for (int k = 0; k < dir.length; k += 2) {
                int newX = x + dir[k], newY = y + dir[k + 1];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (used[newX][newY] == 0 && grid[newX][newY] == '1') {
                        used[newX][newY] = 1;
                        queue.add(newX);
                        queue.add(newY);
                    }
                }
            }
        }
    }
}
