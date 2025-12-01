package problems.leetcode.medium.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem: https://leetcode.com/problems/01-matrix/
 * Time Complexity: O(N*M)
 * Space Complexity：
 */
class Solution542 {
    public int[][] updateMatrix(int[][] mat) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    queue.add(i);
                    queue.add(j);
                } else {
                    mat[i][j] = Integer.MAX_VALUE - 1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int x = queue.remove(), y = queue.remove();

            if (x > 0 && mat[x - 1][y] > mat[x][y] + 1) {
                mat[x - 1][y] = mat[x][y] + 1;
                queue.add(x - 1);
                queue.add(y);
            }
            if (x + 1 < mat.length && mat[x + 1][y] > mat[x][y] + 1) {
                mat[x + 1][y] = mat[x][y] + 1;
                queue.add(x + 1);
                queue.add(y);
            }
            if (y > 0 && mat[x][y - 1] > mat[x][y] + 1) {
                mat[x][y - 1] = mat[x][y] + 1;
                queue.add(x);
                queue.add(y - 1);
            }
            if (y + 1 < mat[0].length && mat[x][y + 1] > mat[x][y] + 1) {
                mat[x][y + 1] = mat[x][y] + 1;
                queue.add(x);
                queue.add(y + 1);
            }
        }
        return mat;
    }
}
