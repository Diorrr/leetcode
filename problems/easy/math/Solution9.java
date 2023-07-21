package problems.easy.math;


/**
 * Problem: <a href="https://leetcode.com/problems/palindrome-number">
 * palindrome-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution9 {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return false;
            }
        }

        return true;
    }
}
