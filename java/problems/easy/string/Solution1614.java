package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses">
 * maximum-nesting-depth-of-the-parentheses</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1614 {
    public int maxDepth(String s) {
        if (s.length() == 0 || (s.length() == 1 && s.charAt(0) != '(' && s.charAt(0) != ')')) {
            return 0;
        } else if (s.charAt(0) == '(' && s.charAt(s.length() - 1) == ')') {
            return 1 + maxDepth(s.substring(1, s.length()));
        } else {
            int pos = s.indexOf('+');
            return Math.max(maxDepth(s.substring(0, pos)), maxDepth(s.substring(pos)));
        }
    }

    public int maxDepth2(String s) {
        int res = 0, cur = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                res = Math.max(res, ++cur);
            } else if (s.charAt(i) == ')') {
                cur--;
            }
        }
        return res;
    }
}
