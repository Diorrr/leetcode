package problems.medium.counting;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/count-servers-that-communicate">
 * count-servers-that-communicate</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1267 {
    public int countServers(int[][] grid) {
        int res = 0;
        int[] rowCount = new int[grid.length];
        int[] colCount = new int[grid[0].length];
        int[] rowPos = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    rowCount[i]++;
                    colCount[j]++;
                    rowPos[i] = j;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (rowCount[i] == 1 && colCount[rowPos[i]] == 1) {
                res--;
            }
        }

        return res;
    }

    public int countServers2(int[][] grid) {
        int res = 0;
        List<List<Integer>> rowPos = new ArrayList<>();
        List<List<Integer>> colPos = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            rowPos.add(new ArrayList<>());
        }
        for (int j = 0; j < grid[0].length; j++) {
            colPos.add(new ArrayList<>());
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res++;
                    rowPos.get(i).add(j);
                    colPos.get(j).add(i);
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            if (rowPos.get(i).size() == 1 && colPos.get(rowPos.get(i).get(0)).size() == 1) {
                res--;
            }
        }

        return res;
    }
}
