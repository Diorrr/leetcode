package problems.easy.string;

/**
 * Problem: https://leetcode.com/problems/reverse-string/
 * Time Complexity: O(N/2)
 * Space Complexity： O(1)
 */
class Solution344 {
    public void reverseString(char[] s) {
        char t;
        for (int i = 0; i < s.length / 2; i++) {
            t = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = t;
        }
    }
}
