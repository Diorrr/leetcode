package problems.leetcode.medium.dp;

import java.util.Arrays;

/**
 * Problem: https://leetcode.com/problems/count-sorted-vowel-strings/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution1641 {
    public int countVowelStrings(int n) {
        int[] all = new int[]{1, 1, 1, 1, 1};
        for (int i = 1; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < all.length; j++) {
                sum += all[j];
                all[j] = sum;
            }
        }
        return Arrays.stream(all).sum();
    }
}
