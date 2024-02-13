package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/find-first-palindromic-string-in-the-array">
 * find-first-palindromic-string-in-the-array</a>
 * Time Complexity: O(N)
 * Space Complexity：
 */
class Solution2108 {
    public String firstPalindrome(String[] words) {
        for (String word : words) {
            if (isPalindrome(word)) {
                return word;
            }
        }

        return "";
    }

    private boolean isPalindrome(String word) {
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
