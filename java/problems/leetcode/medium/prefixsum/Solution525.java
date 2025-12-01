package problems.leetcode.medium.prefixsum;


import java.util.HashMap;

/**
 * Problem: <a href="https://leetcode.com/problems/contiguous-array">
 * contiguous-array</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution525 {
    // from comments
    public int findMaxLength(int[] nums) {
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i] == 0 ? -1 : 1;
            if (sum == 0) {
                res = i + 1;
            } else if (sumToIndex.containsKey(sum)) {
                res = Math.max(i - sumToIndex.get(sum), res);
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return res;
    }

    public int findMaxLength2(int[] nums) {
        int res = 0;
        int[] pref = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            pref[i + 1] += pref[i] + nums[i];
        }
        for (int i = pref.length - 1; i >= 0; i--) {
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
