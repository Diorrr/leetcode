package problems.medium;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Problem: https://leetcode.com/problems/number-of-longest-increasing-subsequence/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution673 {
    public int findNumberOfLIS(int[] nums) {
        int[] count = new int[nums.length + 1];
        int[] dp = new int[nums.length];
        dp[0] = 1;
        count[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            count[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] < nums[i]) {
                    if (dp[j] + 1 > dp[i]) {
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    } else if (dp[j] + 1 == dp[i]) {
                        count[i] += count[j];
                    }
                }
            }
        }
        int res = 1, max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (max < dp[i]) {
                max = dp[i];
                res = count[i];
            } else if (max == dp[i]) {
                res += count[i];
            }
        }

        return res;
    }
}
