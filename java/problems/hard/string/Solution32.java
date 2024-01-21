package problems.hard.string;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-valid-parentheses">
 * longest-valid-parentheses</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution32 {
    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                int count = 0;
                int start = i;
                for (int j = i; j < chars.length; j++) {
                    if (chars[j] == '(') {
                        count++;
                    } else {
                        count--;
                        if (count == 0) {
                            res = Math.max(j - start + 1, res);
                            i = j;
                        } else if (count < 0) {
                            break;
                        }
                    }
                }
            }
        }

        return res;
    }
}
