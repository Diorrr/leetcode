package problems.medium.dp;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-additions-to-make-valid-string">
 * minimum-additions-to-make-valid-string</a>
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution2645 {
    public int addMinimum(String word) {
        int[] dp = new int[word.length()];
        dp[0] = 2;
        for (int i = 1; i < word.length(); i++) {
            char prev = word.charAt(i - 1);
            char curr = word.charAt(i);
            if (curr == 'a') {
                dp[i] = dp[i - 1] + 2;
            } else if (curr == 'b') {
                if (prev == 'a') {
                    dp[i] = dp[i - 1] - 1;
                } else {
                    dp[i] = dp[i - 1] + 2;
                }
            } else {
                if (prev == 'c') {
                    dp[i] = dp[i - 1] + 2;
                } else {
                    dp[i] = dp[i - 1] - 1;
                }
            }
        }
        return dp[dp.length - 1];
    }
}

