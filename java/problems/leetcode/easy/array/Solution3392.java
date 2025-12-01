package problems.leetcode.easy.array;

/**
 * Problem: <a href="https://leetcode.com/problems/count-subarrays-of-length-three-with-a-condition">
 * count-subarrays-of-length-three-with-a-condition</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3392 {
    public int countSubarrays(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            if ((nums[i] + nums[i + 2]) * 2 == nums[i + 1]) {
                res++;
            }
        }
        return res;
    }
}
