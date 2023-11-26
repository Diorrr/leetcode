package problems.easy.binsearch;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/search-insert-position">
 * search-insert-position</a>
 * Time Complexity: O(logN)
 * Space Complexity：O(1)
 */
class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int pos = Arrays.binarySearch(nums, target);
        return pos >= 0 ? pos : Math.abs(pos) - 1;
    }

    public int searchInsert2(int[] nums, int target) {
        int l = -1, r = nums.length;
        int m;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        return r;
    }
}
