package problems.leetcode.medium.twopointer;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/3sum-closest/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = Arrays.stream(nums).limit(3).sum();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - res) > Math.abs(target - sum)) {
                    res = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }
}
