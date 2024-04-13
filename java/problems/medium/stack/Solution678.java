package problems.medium.stack;


import java.util.Stack;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-parenthesis-string">
 * valid-parenthesis-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution678 {
    public boolean checkValidString(String s) {
        if (s.length() == 1) {
            return s.charAt(0) == '*';
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        dp[0][1] = s.charAt(0) != ')' && s.charAt(1) != '(';

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                boolean isToAdd = s.charAt(j) != ')' && s.charAt(i) != '(';
                boolean isValidSubOrAster = dp[j + 1][i - 1] || (j + 1 == i - 1 && s.charAt(j + 1) == '*') || (i - j == 1);
                dp[j][i] = dp[j][i] || (isToAdd && isValidSubOrAster);
            }
        }
        return dp[0][s.length() - 1];
    }

    public boolean checkValidString2(String s) {
        Stack<Integer> open = new Stack<>();
        Stack<Integer> aster = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == '(') {
                open.add(i);
            } else if (curr == '*') {
                aster.add(i);
            } else {
                if (!open.isEmpty()) {
                    open.pop();
                } else if (!aster.isEmpty()) {
                    aster.pop();
                } else {
                    return false;
                }
            }
        }
        while (!open.isEmpty() && !aster.isEmpty()) {
            if (open.pop() > aster.pop()) {
                return false;
            }
        }
        return open.isEmpty();
    }
}
