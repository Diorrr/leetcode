package problems.medium.arrays;


/**
 * Problem: <a href="https://leetcode.com/problems/find-the-power-of-k-size-subarrays-i">
 * find-the-power-of-k-size-subarrays-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3254 {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        boolean isCons = isisCons(nums, 0, k);
        for (int i = 0; i < nums.length - k + 1; i++) {
            if (isCons && nums[i + k - 2] + 1 == nums[i + k - 1]) {
                res[i] = nums[i + k - 1];
            } else if (nums[i + k - 2] + 1 == nums[i + k - 1]) {
                isCons = isisCons(nums, i, i + k);
                res[i] = isCons ? nums[i + k - 1] : -1;
            } else {
                isCons = false;
                res[i] = -1;
            }
        }
        return res;
    }

    private boolean isisCons(int[] nums, int start, int end) {
        for (int i = start + 1; i < end; i++) {
            if (nums[i - 1] + 1 != nums[i]) {
                return false;
            }
        }
        return true;
    }
}
