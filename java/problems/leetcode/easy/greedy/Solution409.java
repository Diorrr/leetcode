package problems.leetcode.easy.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/longest-palindrome">
 * longest-palindrome</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution409 {
    public int longestPalindrome(String s) {
        int res = 0;
        char[] lower = new char[26];
        char[] upper = new char[26];
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c >= 'A' && c <= 'Z') {
                upper[c - 'A']++;
            } else {
                lower[c - 'a']++;
            }
        }
        for (int i = 0; i < 26; i++) {
            res += lower[i] / 2;
            res += upper[i] / 2;
        }
        res *= 2;
        for (int i = 0; i < 26; i++) {
            if (lower[i] % 2 == 1 || upper[i] % 2 == 1) {
                res++;
                break;
            }
        }
        return res;
    }
}
