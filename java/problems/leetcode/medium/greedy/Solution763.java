package problems.leetcode.medium.greedy;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/partition-labels">
 * partition-labels</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution763 {
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        int[] pos = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            pos[chars[i] - 'a'] = i;
        }
        int start = 0;
        int maxPos = pos[chars[0] - 'a'];
        for (int i = 0; i < chars.length; i++) {
            if (i == maxPos) {
                res.add(maxPos - start + 1);
                start = i + 1;
                maxPos = i + 1 < chars.length ? pos[chars[start] - 'a'] : -1;
            }
            maxPos = Math.max(pos[chars[i] - 'a'], maxPos);
        }

        return res;
    }
}
