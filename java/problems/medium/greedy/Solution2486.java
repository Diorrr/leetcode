package problems.medium.greedy;


/**
 * Problem: <a href="https://leetcode.com/problems/append-characters-to-string-to-make-subsequence">
 * append-characters-to-string-to-make-subsequence</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2486 {
    public int appendCharacters(String s, String t) {
        int index = 0;
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        for (int i = 0; i < schar.length && index < tchar.length; i++) {
            if (schar[i] == tchar[index]) {
                index++;
            }
        }
        return tchar.length - index;
    }

    public int appendCharacters2(String s, String t) {
        int index = 0;
        for (int i = 0; i < s.length() && index < t.length(); i++) {
            if (s.charAt(i) == t.charAt(index)) {
                index++;
            }
        }
        return t.length() - index;
    }
}
