package problems.leetcode.easy.string;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-palindrome">
 * valid-palindrome</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution125 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;

        while (l < r) {
            while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while (l < r && !Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public boolean isPalindrome1(String s) {
        char[] chars = s.toLowerCase().toCharArray();
        int r = chars.length - 1;

        for (int l = 0; l < r && l < chars.length; l++) {
            if (Character.isLetterOrDigit(chars[l])) {
                while (r >= 0 && !Character.isLetterOrDigit(chars[r])) {
                    r--;
                }
                if (l < r && chars[l] != chars[r]) {
                    return false;
                }
                r--;
            }
        }

        return true;
    }
}
