package problems.leetcode.medium.math;

/**
 * Problem: <a href="https://leetcode.com/problems/sum-of-absolute-differences-in-a-sorted-array">
 * sum-of-absolute-differences-in-a-sorted-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1685 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] res = new int[nums.length];
        int prefix = 0;
        int suffix = 0;
        for (int num : nums) {
            suffix += num;
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[i] * i - prefix + suffix - nums[i] * (nums.length - i);
            prefix += nums[i];
            suffix -= nums[i];
        }

        return res;
    }
}
