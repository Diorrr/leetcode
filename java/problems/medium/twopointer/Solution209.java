package problems.medium.twopointer;

/**
 * Problem: https://leetcode.com/problems/minimum-size-subarray-sum/
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, sum = 0, res = -1;
        boolean isReached = false;

        while (l < nums.length) {
            if (l == r) {
                if (nums[l] >= target) {
                    return 1;
                } else if (r + 1 < nums.length) {
                    r++;
                    sum = nums[l] + nums[r];
                } else {
                    break;
                }
            } else {
                if (sum >= target) {
                    res = isReached ? Math.min(res, r - l + 1) : r - l + 1;
                    isReached = true;
                    sum -= nums[l++];
                } else if (r + 1 < nums.length) {
                    r++;
                    sum += nums[r];
                } else {
                    break;
                }
            }
        }

        return isReached ? res : 0;
    }
}
