package problems.medium.math;


/**
 * Problem: <a href="https://leetcode.com/problems/strictly-palindromic-number">
 * strictly-palindromic-number</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2396 {
    public boolean isStrictlyPalindromic2(int n) {
        return false;
    }

    public boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i < n - 1; i++) {
            String base = Integer.toString(n, i);
            if (isNotPalindrome(base)) {
                return false;
            }
        }

        return true;
    }

    private boolean isNotPalindrome(String base) {
        for (int i = 0; i < base.length() / 2; i++) {
            if (base.charAt(i) != base.charAt(base.length() - 1 - i)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        new Solution2396().isStrictlyPalindromic(5);
    }
}
