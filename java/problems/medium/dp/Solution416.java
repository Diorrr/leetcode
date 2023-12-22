package problems.medium.dp;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/partition-equal-subset-sum">
 * partition-equal-subset-sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution416 {
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int[][] dp = new int[nums.length + 1][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= sum / 2) {
                dp[i][nums[i]] = 1;
            }
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                if (dp[i - 1][j] == 1) {
                    dp[i][j] = 1;
                    if (j + nums[i] <= sum / 2) {
                        dp[i][j + nums[i]] = 1;
                    }
                    if (dp[i][sum / 2] == 1) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}
