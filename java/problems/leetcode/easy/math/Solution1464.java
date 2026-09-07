package problems.leetcode.easy.math;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array">
 * maximum-product-of-two-elements-in-an-array</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution1464 {
    public int maxProduct(int[] nums) {
        int max1 = nums[0];
        int pos1 = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max1) {
                max1 = nums[i];
                pos1 = i;
            }
        }
        int max2 = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (i != pos1 && nums[i] > max2) {
                max2 = nums[i];
            }
        }
        return (max1 - 1) * (max2 - 1);
    }

    public int maxProduct1(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 2] - 1) * (nums[nums.length - 1] - 1);
    }
}
