package problems.medium.greedy;


import java.util.Arrays;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-number-of-pushes-to-type-word-ii">
 * minimum-number-of-pushes-to-type-word-ii</a>
 * Time Complexity: O(N)
 * Space Complexity：O(1)
 */
class Solution3016 {
    public int minimumPushes(String word) {
        int res = 0;
        int[] count = new int[26];
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        Arrays.sort(count);

        for (int i = 25; i >= 0; i--) {
            res += ((25 - i) / 8 + 1) * count[i];
        }

        return res;
    }
}
