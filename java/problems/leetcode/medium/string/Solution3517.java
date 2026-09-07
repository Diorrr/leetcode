package problems.leetcode.medium.string;

/**
 * Problem: <a href="https://leetcode.com/problems/smallest-palindromic-rearrangement-i">
 * smallest-palindromic-rearrangement-i</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution3517 {
    public String smallestPalindrome(String s) {
        StringBuilder pref = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                char toAdd = (char) ('a' + i);
                pref.append(String.valueOf(toAdd).repeat(Math.max(0, count[i] / 2)));
                if (count[i] % 2 == 1) {
                    mid.append(toAdd);
                }
            }
        }
        String prefix = pref.toString();
        return prefix + mid + pref.reverse();
    }
}
