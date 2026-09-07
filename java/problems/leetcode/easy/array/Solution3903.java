package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-stable-index-i">
 * smallest-stable-index-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3903 {
    public int firstStableIndex(int[] nums, int k) {
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i], max);
            int min = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                min = Math.min(nums[j], min);
            }
            if (max-min<=k){
                return i;
            }
        }
        return -1;
    }
}
