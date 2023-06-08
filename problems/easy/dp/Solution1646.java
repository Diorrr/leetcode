package problems.easy.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/get-maximum-in-generated-array/">
 * get-maximum-in-generated-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1646 {
    public int getMaximumGenerated(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int[] num = new int[n + 1];
        int res = 0;
        num[0] = 0;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            num[i] = i % 2 == 0 ? num[i / 2] : num[(i - 1) / 2] + num[(i + 1) / 2];
            res = Math.max(res, num[i]);
        }

        return res;
    }
}
