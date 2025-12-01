package problems.leetcode.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-add-to-make-parentheses-valid">
 * minimum-add-to-make-parentheses-valid</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution921 {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    close++;
                }
            }
        }

        return open + close;
    }
}
