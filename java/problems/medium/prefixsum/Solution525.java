package problems.medium.prefixsum;


/**
 * Problem: <a href="https://leetcode.com/problems/contiguous-array">
 * contiguous-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution525 {
    public int findMaxLength(int[] nums) {
        int res = 0;
        int[] pref = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pref[i + 1] += pref[i] + nums[i];
        }
        for (int i = 1; i < pref.length; i++) {
            int len = pref[i] * 2;
            while (len > 0 && len > res) {
                if (i - len >= 0 && (pref[i] - pref[i - len]) * 2 == len) {
                    res = len;
                } else {
                    len -= 2;
                }
            }
        }
        return res;
    }
}
