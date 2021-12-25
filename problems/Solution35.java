package problems;

/**
 * Problem: https://leetcode.com/problems/search-insert-position/
 * Time Complexity: O(logN)
 * Space Complexity： O(1)
 */
class Solution35 {
    public int searchInsert(int[] nums, int target) {
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

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(new Solution35().searchInsert(nums, 2));
    }
}
