package problems.easy;

/**
 * Problem: https://leetcode.com/problems/reverse-words-in-a-string-iii/
 * Time Complexity: O(N)
 * Space Complexity： O(N)
 */
class Solution557 {
    public String reverseWords(String s) {
        int start = 0, end = 0;
        boolean isSubstring = false;
        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            if (!isSubstring && s.charAt(i) != ' ') {
                start = i;
                isSubstring = true;
            } else if (isSubstring && s.charAt(i) != ' ') {
                end = i;
            } else if (isSubstring && s.charAt(i) == ' ') {
                swap(result, start, end);
                isSubstring = false;
            }
        }
        if (isSubstring) {
            swap(result, start, end);
        }

        return result.toString();
    }

    private void swap(StringBuilder s, int start, int end) {
        char t;
        while (start < end) {
            t = s.charAt(start);
            s.setCharAt(start++, s.charAt(end));
            s.setCharAt(end--, t);
        }
    }
}
