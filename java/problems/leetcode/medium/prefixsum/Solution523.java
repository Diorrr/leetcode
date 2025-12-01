package problems.leetcode.medium.prefixsum;


/**
 * Problem: <a href="https://leetcode.com/problems/continuous-subarray-sum">
 * continuous-subarray-sum</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] + nums[i + 1]) == 0) {
                return true;
            }
        }
        int[] prefix = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefix[i + 1] += nums[i] + prefix[i];
        }
        for (int i = 2; i < prefix.length; i++) {
            for (int j = 0; j + 1 < i && prefix[i] - prefix[j] >= k; j++) {
                if ((prefix[i] - prefix[j]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
