package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/length-of-last-word/">
 * length-of-last-word/</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution58 {
    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (s.charAt(end) == ' ') {
            end--;
        }
        int begin = end;
        while (begin >= 0 && s.charAt(begin) != ' ') {
            begin--;
        }

        return end - begin;
    }
}
