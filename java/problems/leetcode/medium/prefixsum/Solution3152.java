package problems.leetcode.medium.prefixsum;


/**
 * Problem: <a href="https://leetcode.com/problems/special-array-ii">
 * special-array-ii</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        int[] pref = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            pref[i] += pref[i - 1] + ((nums[i - 1] % 2 == nums[i] % 2) ? 1 : 0);
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = (pref[queries[i][1]] - pref[queries[i][0]]) == 0;
        }

        return res;
    }
}
