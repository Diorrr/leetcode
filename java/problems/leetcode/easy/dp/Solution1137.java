package problems.leetcode.easy.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/n-th-tribonacci-number/">
 * n-th-tribonacci-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1137 {
    public int tribonacci(int n) {
        int[] trib = new int[Math.max(3, n + 1)];
        trib[0] = 0;
        trib[1] = 1;
        trib[2] = 1;
        for (int i = 3; i <= n; i++) {
            trib[i] = trib[i - 3] + trib[i - 2] + trib[i - 1];
        }
        return trib[n];
    }
}
