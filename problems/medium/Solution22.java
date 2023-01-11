package problems.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: https://leetcode.com/problems/generate-parentheses/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution22 {
    List<String> res = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, "", 0, 0);
        return res;
    }

    private void backtrack(int n, String s, int openPrn, int closedPrn) {
        if (openPrn == n && closedPrn == n) {
            res.add(s);
        } else {
            if (openPrn < n) {
                backtrack(n, s + "(", openPrn + 1, closedPrn);
            }
            if (openPrn - closedPrn > 0) {
                backtrack(n, s + ")", openPrn, closedPrn + 1);
            }
        }
    }
}
