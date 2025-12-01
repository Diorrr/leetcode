package problems.leetcode.easy.binsearch;

/**
 * Problem: <a href="https://leetcode.com/problems/binary-search">
 * binary-search</a>
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
