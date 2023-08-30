package problems.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/maximize-the-topmost-element-after-k-moves">
 * maximize-the-topmost-element-after-k-moves</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2202 {
    public int maximumTop(int[] nums, int k) {
        int res = -1;
        if (nums.length == 1 && k % 2 == 1) {
            return -1;
        }
        res = nums[0];
        for (int i = 0; i < nums.length && i <= k; i++) {
            if (i == k) {
                res = Math.max(res, nums[i]);
            }
            if ((k - i) % 2 == 0) {
                res = Math.max(res, nums[i]);
            }
            if ((k - i - 2) % 2 == 1) {
                res = Math.max(res, nums[i]);
            }
            if ((k - i - 1) % 2 == 1) {
                res = Math.max(res, nums[i]);
            }
            if (i + 1 < nums.length && (k - i - 2) % 2 == 1) {
                res = Math.max(res, nums[i]);
            }
        }

        return res;
    }
}
