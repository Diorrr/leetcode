package problems.medium.dp;


import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/extra-characters-in-a-string">
 * extra-characters-in-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2707 {
    public int minExtraChar(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        Set<String> set = new HashSet<>(Arrays.asList(dictionary));

        for (int i = 1; i <= s.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            for (int j = 0; j < i; j++) {
                String tempR = s.substring(j, i);
                if (set.contains(tempR)) {
                    dp[i] = Math.min(dp[i], dp[j]);
                }
            }
        }
        return dp[s.length()];
    }

    public int minExtraChar2(String s, String[] dictionary) {
        int[] dp = new int[s.length() + 1];
        HashMap<String, Integer> dictMap = new HashMap<>();
        for (String word : dictionary) {
            dictMap.put(word, 0);
        }

        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = i;
            for (int j = 0; j < i; j++) {
                String tempR = s.substring(j, i);
                dp[i] = Math.min(dp[i], dp[j] + dictMap.getOrDefault(tempR, tempR.length()));
            }
        }
        return dp[s.length()];
    }
}
