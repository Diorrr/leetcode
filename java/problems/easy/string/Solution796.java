package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/rotate-string">
 * rotate-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution796 {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        StringBuilder pref = new StringBuilder(s);
        StringBuilder suf = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (goal.startsWith(pref.toString()) && goal.endsWith(suf.toString())) {
                return true;
            }
            pref.deleteCharAt(0);
            suf.append(c);
        }

        return false;
    }
}
