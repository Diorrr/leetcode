package problems.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem: <a href="https://leetcode.com/problems/generate-parentheses">
 * generate-parentheses</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, new char[2 * n], 0, 0);
        return res;
    }

    private void backtrack(int n, char[] s, int open, int close) {
        if (open == n && close == n) {
            res.add(new String(s));
            return;
        }
        if (open < n) {
            s[open + close] = '(';
            backtrack(n, s, open + 1, close);
        }
        if (open > close) {
            s[open + close] = ')';
            backtrack(n, s, open, close + 1);
        }
    }

    public List<String> generateParenthesis1(int n) {
        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        Queue<Integer> openClose = new LinkedList<>();
        queue.add("");
        openClose.add(0);
        openClose.add(0);

        while (!queue.isEmpty()) {
            int open = openClose.poll();
            int close = openClose.poll();
            String s = queue.poll();
            if (open == n && close == n) {
                res.add(s);
            }
            if (open < n) {
                queue.add(s + "(");
                openClose.add(open + 1);
                openClose.add(close);
            }
            if (open > close) {
                queue.add(s + ")");
                openClose.add(open);
                openClose.add(close + 1);
            }
        }

        return res;
    }
}
