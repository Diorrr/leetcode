package problems.leetcode.medium.bit;


/**
 * Problem: <a href="https://leetcode.com/problems/find-the-original-array-of-prefix-xor">
 * find-the-original-array-of-prefix-xor</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2433 {
    public int[] findArray(int[] pref) {
        int[] res = new int[pref.length];
        res[0] = pref[0];
        for (int i = 1; i < res.length; i++) {
            res[i] = pref[i] ^ pref[i-1];
        }

        return res;
    }
}
