package problems.hard.window;


/**
 * Problem: <a href="https://leetcode.com/problems/count-subarrays-with-fixed-bounds">
 * count-subarrays-with-fixed-bounds</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2444 {
    // from solutions
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        int invalPos = -1;
        int minPos = -1;
        int maxPos = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                invalPos = i;
            }
            if (nums[i] == minK) {
                minPos = i;
            }
            if (nums[i] == maxK) {
                maxPos = i;
            }
            res += Math.max(0, Math.min(minPos, maxPos) - invalPos);
        }

        return res;
    }
}
