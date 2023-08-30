package problems.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/shift-2d-grid/
 * Time Complexity: O(mn)
 * Space Complexity： O(mn)
 */
class Solution1260 {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int[] ints : grid) {
            for (int anInt : ints) {
                temp.add(anInt);
            }
        }
        k = k % temp.size();
        int pos = temp.size()-k;
        for (int[] ints : grid) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < ints.length; j++) {
                if (pos == temp.size()) {
                    pos = 0;
                }
                row.add(temp.get(pos));
                pos++;
            }
            res.add(row);
        }

        return res;
    }
}
