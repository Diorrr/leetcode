package problems.leetcode.medium.dp;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-increasing-subsequence">
 * longest-increasing-subsequence</a>
 * Time Complexity: O(N logN)
 * Space Complexity： O(N)
 */
class Solution300 {
    // from comments
    public int lengthOfLIS(int[] nums) {
        int size = 0;
        int[] tails = new int[nums.length];

        for (int num : nums) {
            int left = 0;
            int right = size;

            while (left < right) {
                int mid = (left + right) / 2;
                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            tails[left] = num;
            if (left == size) {
                size++;
            }
        }

        return size;
    }

    public int lengthOfLIS1(int[] nums) {
        int res = 0;
        int[] dp = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            res = Math.max(res, dp[i]);
        }

        return res + 1;
    }
}
