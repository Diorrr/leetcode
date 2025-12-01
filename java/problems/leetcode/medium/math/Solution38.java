package problems.leetcode.medium.math;

/**
 * Problem: <a href="problems.leetcode.com/problems/count-and-say">
 * count-and-say</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution38 {
    public String countAndSay(int n) {
        String[] dp = new String[31];
        dp[1] = "1";
        dp[2] = "11";
        dp[3] = "21";
        for (int i = 4; i <= n; i++) {
            dp[i] = convert(dp[i - 1].toCharArray());
        }
        return dp[n];
    }

    private String convert(char[] s) {
        StringBuilder sb = new StringBuilder();
        char curr = s[0];
        int count = 1;
        for (int i = 1; i < s.length; i++) {
            if (curr == s[i]) {
                count++;
            } else {
                sb.append(count);
                sb.append(curr);
                count = 1;
                curr = s[i];
            }
        }
        sb.append(count);
        sb.append(curr);

        return sb.toString();
    }
}
