package problems.medium.string;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-substring-with-maximum-cost">
 * find-the-substring-with-maximum-cost</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2606 {
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<String, Integer> cost = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            cost.put(String.valueOf(chars.charAt(i)), vals[i]);
        }
        for (char i = 'a'; i <= 'z'; i++) {
            cost.putIfAbsent(String.valueOf(i), i - 'a' + 1);
        }
        int res = 0;
        int temp = 0;
        for (char c : s.toCharArray()) {
            temp += cost.get(String.valueOf(c));
            if (temp < 0) {
                temp = 0;
            }
            res = Math.max(res, temp);
        }

        return res;
    }
}
