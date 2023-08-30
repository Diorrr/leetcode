package problems.medium.dp;

/**
 * Problem: https://leetcode.com/problems/decode-ways/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution91 {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') {
            return 0;
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        for (int i = 0; i < s.length(); i++) {
            int index = i + 1;
            if (s.charAt(i) != '0') {
                dp[index] += dp[index - 1];
                if (index - 2 >= 0) {
                    int digit2 = Integer.parseInt(s.substring(i - 1, i + 1)) - 1;
                    if (Character.isUpperCase(('A' + digit2))) {
                        dp[index] += dp[index - 2];
                    }
                }
            } else {
                dp[index - 1] = 0;
                if (index - 2 >= 0) {
                    int digit2 = Integer.parseInt(s.substring(i - 1, i + 1)) - 1;
                    if (Character.isUpperCase('A' + digit2)) {
                        dp[index] += dp[index - 2];
                    }
                }
            }
        }
        return dp[s.length()];
    }
}
