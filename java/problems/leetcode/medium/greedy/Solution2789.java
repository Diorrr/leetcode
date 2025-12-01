package problems.leetcode.medium.greedy;

/**
 * Problem: <a href="https://leetcode.com/problems/largest-element-in-an-array-after-merge-operations">
 * largest-element-in-an-array-after-merge-operations</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2789 {
    public long maxArrayValue(int[] nums) {
        long sum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] <= sum) {
                sum += nums[i];
            } else {
                sum = nums[i];
            }
        }

        return sum;
    }
}
