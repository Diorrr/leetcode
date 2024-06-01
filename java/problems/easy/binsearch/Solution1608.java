package problems.easy.binsearch;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x">
 * special-array-with-x-elements-greater-than-or-equal-x</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1608 {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int res = nums.length - mid;
            if (res <= nums[mid] && (mid == 0 || res > nums[mid - 1])) {
                return res;
            } else if (res > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }

    public int specialArray2(int[] nums) {
        int res = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++, res--) {
            if (res <= nums[i] && (i == 0 || res > nums[i - 1])) {
                return res;
            }
            res--;
        }
        return -1;
    }
}
