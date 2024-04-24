package problems.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/knight-dialer">
 * knight-dialer</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution935 {
    public int knightDialer(int n) {
        int[][] dp = new int[n][10];
        int[][] toAdd = new int[][]{{4,6},{6,8},{7,9},{4,8},{0,3,9},{},{0,1,7},{2,6},{1,3},{2,4}};
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int to : toAdd[j]) {
                    dp[i][to]= (dp[i][to] + dp[i-1][j]) % 1000000007;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 10; i++) {
            res= (res + dp[n-1][i]) % 1000000007;
        }

        return res;
    }
}
