package problems.medium.string;


/**
 * Problem: <a href="https://leetcode.com/problems/decoded-string-at-index">
 * decoded-string-at-index</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution880 {
    public String decodeAtIndex(String s, int k) {
        int pos = 0;
        long length = 0;
        for (; length < k; pos++) {
            length = Character.isLetter(s.charAt(pos)) ? length + 1 : length * (s.charAt(pos) - '0');
        }
        for (pos--; pos >= 0; pos--) {
            if (Character.isDigit(s.charAt(pos))) {
                length /= s.charAt(pos) - '0';
                k %= length;
            } else {
                if (k % length == 0) {
                    break;
                }
                length--;
            }
        }

        return String.valueOf(s.charAt(pos));
    }
}
