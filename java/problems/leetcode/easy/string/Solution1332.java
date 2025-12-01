package problems.leetcode.easy.string;

/**
 * Problem: https://leetcode.com/problems/remove-palindromic-subsequences/
 * Time Complexity: O(n)
 * Space Complexity：
 */
class Solution1332 {

    public int removePalindromeSub(String s) {
        if (s.isEmpty()) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isPalindrome(String s) {
        return new StringBuilder(s.substring((s.length() + 1) / 2)).reverse().toString().equals(s.substring(0, s.length() / 2));
    }
}
