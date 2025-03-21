package problems.easy.twopointer;

/**
 * Problem: <a href="https://leetcode.com/problems/is-subsequence">
 * is-subsequence</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int pointerS = 0;
        char[] sCharArray = s.toCharArray();
        char[] tCharArray = t.toCharArray();

        for (int pointerT = 0; pointerT < t.length() && pointerS < s.length(); pointerT++) {
            if (sCharArray[pointerS] == tCharArray[pointerT]) {
                pointerS++;
            }
        }

        return pointerS == s.length();
    }

    public boolean isSubsequence1(String s, String t) {
        int pointerS = 0;
        int pointerT = 0;
        while (pointerT < t.length() && pointerS < s.length()) {
            if (s.charAt(pointerS) == t.charAt(pointerT)) {
                pointerS++;
            }
            pointerT++;
        }

        return pointerS >= s.length();
    }

    public boolean isSubsequence2(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int pos = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(pos) == t.charAt(i)) {
                pos++;
            }
            if (pos == s.length()) {
                return true;
            }
        }

        return t.length() == pos;
    }
}
