package problems.medium.dp;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/partition-array-for-maximum-sum/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1043 {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i + 1] = arr[i];
            for (int j = Math.max(0, i - k + 1); j <= i; j++) {
                int max = Arrays.stream(arr, j, i + 1).max().getAsInt();
                dp[i + 1] = Math.max(dp[i+1], dp[j] + max *
                        (i - j + 1));
            }
        }

        return dp[arr.length];
    }
}
