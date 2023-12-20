package problems.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/perfect-squares">
 * perfect-squares</a>
 * Time Complexity: O(N sqrt(N))
 * Space Complexity： O(N)
 */
class Solution279 {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(1 + dp[i - j * j], dp[i]);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

    }
}
