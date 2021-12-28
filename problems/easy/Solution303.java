package problems.easy;

/**
 * Problem: https://leetcode.com/problems/range-sum-query-immutable/
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution303 {
    int[] sum;

    public Solution303(int[] nums) {
        sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return sum[right];
        }
        return sum[right] - sum[left - 1];
    }
}
