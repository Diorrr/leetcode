package problems.leetcode.easy.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/baseball-game/
 * Time Complexity:
 * Space Complexity：
 */
class Solution682 {
    public int calPoints(String[] ops) {
        List<Integer> res = new ArrayList<>();
        for (String op : ops) {
            if (op.equals("+")) {
                res.add(res.get(res.size() - 1) + res.get(res.size() - 2));
            } else if (op.equals("C")) {
                if (res.size() > 0) {
                    res.remove(res.size() - 1);
                }
            } else if (op.equals("D")) {
                res.add(2 * res.get(res.size() - 1));
            } else {
                res.add(Integer.parseInt(op));
            }
        }

        return res.stream().mapToInt(Integer::intValue).sum();
    }
}
