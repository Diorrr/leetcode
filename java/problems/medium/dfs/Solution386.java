package problems.medium.dfs;


import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/lexicographical-numbers">
 * lexicographical-numbers</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution386 {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int curr, int n, List<Integer> res) {
        if (curr <= n) {
            res.add(curr);
            for (int i = 0; i < 10 && curr * 10 + i <= n; i++) {
                dfs(curr * 10 + i, n, res);
            }
        }
    }
}
