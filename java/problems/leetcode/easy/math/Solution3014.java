package problems.leetcode.easy.math;

import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-i">
 * minimum-number-of-pushes-to-type-word-i</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution3014 {
    public int minimumPushes(String word) {
        int n = word.length();
        return ((2 * 8 + 8 * (n / 8 - 1)) * (n / 8)) / 2 + (n % 8) * (n / 8 + 1);
    }

    public int minimumPushes1(String word) {
        int res = 0;
        int[] count = new int[26];
        int keyCount = 8;
        int keyCoef = 1;
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);
        for (int i = count.length - 1; i >= 0; i--) {
            if (count[i] > 0) {
                res += count[i] * keyCoef;
                keyCount--;
                if (keyCount == 0) {
                    keyCount = 8;
                    keyCoef++;
                }
            }
        }
        return res;
    }
}
