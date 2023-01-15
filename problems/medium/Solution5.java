package problems.medium;

/**
 * Problem: https://leetcode.com/problems/longest-palindromic-substring/
 * Time Complexity:
 * Space Complexity：
 */
class Solution5 {
    public String longestPalindrome(String s) {
        for (int i = s.length(); i > 0; i--) {
            for (int j = 0; j + i < s.length()+1; j++) {
                String substring = s.substring(j, j + i);
                if (isPalindrome(substring)) {
                    return substring;
                }
            }
        }

        return s;
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
