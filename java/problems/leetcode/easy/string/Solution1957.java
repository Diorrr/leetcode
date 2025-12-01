package problems.leetcode.easy.string;

/**
 * Problem: <a href="https://leetcode.com/problems/delete-characters-to-make-fancy-string">
 * delete-characters-to-make-fancy-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1957 {
    public String makeFancyString(String s) {
        if (s.length() < 3) {
            return s;
        }
        char[] chars = s.toCharArray();
        char prev = chars[0];
        char last = chars[1];
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]).append(chars[1]);

        for (int i = 2; i < chars.length; i++) {
            if (chars[i] != last || chars[i] != prev) {
                sb.append(chars[i]);
                prev = last;
                last = chars[i];
            }
        }

        return sb.toString();
    }
}
