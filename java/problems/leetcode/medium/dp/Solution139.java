package problems.leetcode.medium.dp;

import java.util.List;

/**
 * Problem: https://leetcode.com/problems/word-break/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                dp[word.length()] = true;
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (dp[i]) {
                for (String word : wordDict) {
                    if (s.startsWith(word, i)) {
                        dp[i + word.length()] = true;
                    }
                }
            }
        }

        return dp[s.length()];
    }
}
