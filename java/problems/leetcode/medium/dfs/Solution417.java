package problems.leetcode.medium.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/pacific-atlantic-water-flow/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution417 {
    int[] dir = {-1, 0, 0, -1, 0, 1, 1, 0};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        int[][] acc = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if (isReachable(i, j, heights, new int[heights.length][heights[0].length], acc) == 3) {
                    acc[i][j] = 1;
                    res.add(List.of(i, j));
                }
            }
        }

        return res;
    }

    private int isReachable(int i, int j, int[][] heights, int[][] used, int[][] acc) {
        used[i][j] = 1;
        int isPacific = 0, isAtlantic = 0;
        if (i == 0 || j == 0) {
            isPacific = 1;
        }
        if (i == heights.length - 1 || j == heights[0].length - 1) {
            isAtlantic = 2;
        }
        for (int k = 0; k < dir.length; k += 2) {
            int newX = i + dir[k], newY = j + dir[k + 1];
            if (newX >= 0 && newX < heights.length && newY >= 0 && newY < heights[0].length) {
                if (used[newX][newY] == 0 && heights[i][j] >= heights[newX][newY]) {
                    if (acc[newX][newY] == 1) {
                        return 3;
                    }
                    int res = isReachable(newX, newY, heights, used, acc);
                    if (res == 1) {
                        isPacific = 1;
                    } else if (res == 2) {
                        isAtlantic = 2;
                    } else if (res == 3) {
                        return 3;
                    }
                }
            }
        }

        return isPacific + isAtlantic;
    }
}
