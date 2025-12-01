package problems.leetcode.medium.backtracking;


/**
 * Problem: <a href="https://leetcode.com/problems/2-keys-keyboard">
 * 2-keys-keyboard</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution650 {
    public int minSteps(int n) {
        int res = n;
        if (n == 1) {
            return 0;
        }
        if (n > 5) {
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    res = Math.min(minSteps(n / i) + i, res);
                    res = Math.min(minSteps(n / (n / i)) + (n / i), res);
                }
            }
        }

        return res;
    }
}
