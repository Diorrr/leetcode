package problems.medium.dp;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-ideal-subsequence">
 * longest-ideal-subsequence</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2370 {
    public int longestIdealString(String s, int k) {
        Map<Character, Integer> charMax = new HashMap<>();
        int dp[] = new int[s.length()];
        int res = 1;
        dp[0] = 1;
        charMax.put(s.charAt(0), 1);

        for (int i = 1; i < s.length(); i++) {
            char currChar = s.charAt(i);
            for (char neigh = (char) Math.max('a', currChar - k); neigh <= Math.min('z', currChar + k); neigh++) {
                dp[i] = Math.max(dp[i], charMax.getOrDefault(neigh, -1) + 1);
            }
            charMax.put(currChar, Math.max(charMax.getOrDefault(currChar, 1), dp[i]));
            res = Math.max(res, dp[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(
                new Solution2370().longestIdealString("a", 4)
        );
    }
}
