package problems.medium.backtracking;

import java.util.HashSet;

/**
 * Problem: <a href="https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings">
 * split-a-string-into-the-max-number-of-unique-substrings</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1593 {
    Integer res = 0;

    public int maxUniqueSplit(String s) {
        backtrack(s.toCharArray(), new HashSet<>(), 0);
        return res;
    }

    private void backtrack(char[] s, HashSet<Object> substringSet, int pos) {
        StringBuilder sb = new StringBuilder();
        for (int i = pos; i < s.length; i++) {
            sb.append(s[i]);
            if (!substringSet.contains(sb.toString())) {
                HashSet newSet = new HashSet(substringSet);
                newSet.add(sb.toString());
                res = Math.max(res, newSet.size());
                backtrack(s, newSet, i + 1);
            }
        }
    }
}
