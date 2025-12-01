package problems.leetcode.medium.prefixsum;


/**
 * Problem: <a href="https://leetcode.com/problems/subarray-sums-divisible-by-k">
 * subarray-sums-divisible-by-k</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution974 {
    public int subarraysDivByK(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        int[] remainder = new int[k];
        remainder[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = (sum%k + k) % k;
            res += remainder[rem];
            remainder[rem]++;
        }

        return res;
    }
}
