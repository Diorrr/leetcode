package problems.easy.binsearch;

/**
 * Problem: https://leetcode.com/problems/binary-search/
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution704 {
    public int search(int[] nums, int target) {
        int l = -1, r = nums.length;
        int m;
        while (l < r - 1) {
            m = (l + r) / 2;
            if (nums[m] < target) {
                l = m;
            } else {
                r = m;
            }
        }
        if (r!= nums.length && nums[r] == target) {
            return r;
        } else {
            return -1;
        }
    }
}
