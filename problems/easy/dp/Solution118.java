package problems.easy.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/pascals-triangle/
 * Time Complexity:
 * Space Complexity：
 */
class Solution118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(1);
        res.add(level);

        for (int i = 1; i < numRows; i++) {
            level = new ArrayList<>();
            level.add(1);
            for (int j = 1; j < res.get(i - 1).size(); j++) {
                level.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            level.add(1);

            res.add(level);
        }
        return res;
    }
}
