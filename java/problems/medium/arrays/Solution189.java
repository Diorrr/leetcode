package problems.medium.arrays;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/rotate-array/
 * Time Complexity:
 * Space Complexity：
 */
class Solution189 {

    public void rotate(int[] nums, int k) {
        if (nums.length <= k) {
            k = k % nums.length;
        }
        int[] array1 = Arrays.copyOfRange(nums, nums.length - k, nums.length);
        int[] array2 = Arrays.copyOfRange(nums, 0, nums.length - k);
        System.arraycopy(array1, 0, nums, 0, array1.length);
        System.arraycopy(array2, 0, nums, array1.length, array2.length);
    }

    // elegant solution from discussions with swaps
    public void rotate2(int[] nums, int k) {
        if (nums.length <= k) {
            k = k % nums.length;
        }
        swap(nums, 0, nums.length-1);
        swap(nums, 0, k - 1);
        swap(nums, k, nums.length-1);
    }

    private void swap(int[] nums, int start, int end) {
        int t;
        while (start < end) {
            t = nums[start];
            nums[start] = nums[end];
            nums[end] = t;
            start++;
            end--;
        }
    }

}
