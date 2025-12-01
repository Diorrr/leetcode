package problems.leetcode.medium.dp;

/**
 * Problem: https://leetcode.com/problems/solving-questions-with-brainpower/
 * Time Complexity:
 * Space Complexity：
 */
class Solution2140 {
    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        for (int i = questions.length - 1; i >= 0; i--) {
            dp[i] = Math.max(dp[i + 1],
                    questions[i][0] + ((questions[i][1] + i + 1 < questions.length) ? dp[questions[i][1] + i + 1] : 0));
        }

        return dp[0];
    }
}
