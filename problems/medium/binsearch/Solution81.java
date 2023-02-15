package problems.medium.binsearch
        ;

/**
 * Problem: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution81 {
    public boolean search(int[] nums, int target) {
        int m = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                m = i - 1;
                break;
            }
        }
        int l = binSearch(nums, target, 0, m);
        int r = binSearch(nums, target, m + 1, nums.length - 1);

        return Math.max(l, r) != -1;
    }

    private int binSearch(int[] nums, int target, int l, int r) {
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] == target) {
                return m;
            } else if (nums[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }
        return -1;
    }
}
