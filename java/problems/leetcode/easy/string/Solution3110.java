package problems.leetcode.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/score-of-a-string">
 * score-of-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3110 {
    public int scoreOfString(String s) {
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            res += Math.abs(s.charAt(i - 1) - s.charAt(i));
        }
        return res;
    }
}
