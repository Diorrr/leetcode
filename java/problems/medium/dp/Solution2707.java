package problems.medium.dp;


import java.util.HashMap;

/**
 * Problem: <a href="https://leetcode.com/problems/extra-characters-in-a-string">
 * extra-characters-in-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2707 {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        HashMap<String, Integer> dictMap = new HashMap<>();
        for (String word : dictionary) {
            dictMap.put(word, 0);
        }

        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                String tempL = s.substring(0, j);
                String tempR = s.substring(j, i);
                dp[i] = Math.min(dp[i], dp[j] + dictMap.getOrDefault(tempR, tempR.length()));
            }
        }
        return dp[s.length()];
    }
}
