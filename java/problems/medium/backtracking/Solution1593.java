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
        backtrack(s, new HashSet<>());
        return res;
    }

    private void backtrack(String s, HashSet<Object> substringSet) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            HashSet newSet = new HashSet(substringSet);
            newSet.add(sb.toString());
            res = Math.max(res, newSet.size());
            backtrack(s.substring(i+1), newSet);
        }
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution1593().maxUniqueSplit("ababccc")
        );
    }
}
