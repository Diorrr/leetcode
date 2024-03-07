package problems.medium.twopointer;


/**
 * Problem: <a href="https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends">
 * minimum-length-of-string-after-deleting-similar-ends</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1750 {
    public int minimumLength(String s) {
        char[] chars = s.toCharArray();
        int l = 0;
        int r = chars.length - 1;
        Character curr = l != r && chars[l] == chars[r] ? chars[0] : null;
        while (curr != null) {
            if (r - l == 1 && chars[l] == chars[r]) {
                return 0;
            }
            if (r - l == 2 && chars[l] == chars[r]) {
                return chars[l] == chars[l + 1] ? 0 : 1;
            }
            while (l + 1 < r && chars[l] == curr) {
                l++;
            }
            while (l < r - 1 && chars[r] == curr) {
                r--;
            }
            curr = l != r && chars[l] == chars[r] ? chars[l] : null;

        }

        return r - l + 1;
    }
}
