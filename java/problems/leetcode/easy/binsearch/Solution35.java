package problems.leetcode.easy.binsearch;

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
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
