package problems.leetcode.medium.recursion;


/**
 * Problem: <a href="https://leetcode.com/problems/k-th-symbol-in-grammar">
 * k-th-symbol-in-grammar</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution779 {
    public int kthGrammar(int n, int k) {
        return find(n, k);
    }

    private int find(int n, int k) {
        if (n == 1) {
            return 0;
        }
        if (find(n - 1, (k + 1) / 2) == 0) {
            return k % 2 == 0 ? 1 : 0;
        } else {
            return k % 2 == 0 ? 0 : 1;
        }
    }
}
