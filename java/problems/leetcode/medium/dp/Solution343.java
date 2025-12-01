package problems.leetcode.medium.dp;


/**
 * Problem: <a href="link">
 * problem</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution343 {
    public int integerBreak(int n) {
        if (n <= 3) {
            return n == 3 ? 2 : 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for (int i = 5; i <= n; i++) {
            for (int j = 2; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], j * dp[i - j]);
            }
        }


        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution343().integerBreak(11)
        );
    }
}
