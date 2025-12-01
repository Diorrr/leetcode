package problems.leetcode.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/xor-queries-of-a-subarray">
 * xor-queries-of-a-subarray</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] res = new int[queries.length];
        int[] pref = new int[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            pref[i + 1] = pref[i] ^ arr[i];
        }
        for (int i = 0; i < queries.length; i++) {
            res[i] = pref[queries[i][1] + 1] ^ pref[queries[i][0]];
        }

        return res;
    }
}
