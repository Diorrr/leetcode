package problems.medium.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/stone-game">stone-game</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution877 {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n + 2][n + 2];

        for (int size = 0; size < n; size++) {
            for (int i = 0; i + size < n; i++) {
                int j = i + size;
                int parity = (j + i + n) % 2;
                if (parity == 1)
                    dp[i + 1][j + 1] = Math.max(piles[i] + dp[i + 2][j + 1], piles[j] + dp[i + 1][j]);
                else
                    dp[i + 1][j + 1] = Math.min(-piles[i] + dp[i + 2][j + 1], -piles[j] + dp[i + 1][j]);
            }
        }

        return dp[1][n] > 0;
    }

    public boolean stoneGame2(int[] piles) {
        return true;
    }

    public static void main(String[] args) {

    }
}
