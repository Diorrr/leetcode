package problems.leetcode.medium.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-arithmetic-subsequence-of-given-difference">
 * longest-arithmetic-subsequence-of-given-difference</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1218 {
    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> score = new HashMap<>();
        int res = Math.min(arr.length, 1);
        for (int number : arr) {
            score.put(number, score.getOrDefault(number - difference, 0) + 1);
            res = Math.max(res, score.get(number));
        }
        return res;
    }
}
