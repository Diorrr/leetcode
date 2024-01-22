package problems.hard.string;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-valid-parentheses">
 * longest-valid-parentheses</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution32 {
    public int longestValidParentheses(String s) {
        int[] longestValid = new int[s.length()];
        int res = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    longestValid[i] = 2 + (i > 1 ? longestValid[i - 2] : 0);
                } else if (i - longestValid[i - 1] - 1 >= 0 && s.charAt(i - longestValid[i - 1] - 1) == '(') {
                    longestValid[i] = 2 + longestValid[i - 1] +
                            ((i - longestValid[i - 1] - 2 >= 0) ? longestValid[i - longestValid[i - 1] - 2] : 0);

                }
                res = Math.max(longestValid[i], res);
            }
        }

        return res;
    }

    public int longestValidParentheses2(String s) {
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
