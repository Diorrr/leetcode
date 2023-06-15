package problems.medium.string;

/**
 * Problem: <a href="https://leetcode.com/problems/count-substrings-that-differ-by-one-character">
 * count-substrings-that-differ-by-one-character</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1638 {
    public int countSubstrings(String s, String t) {
        int res = 0;
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        for (int i = 0; i < sChars.length; i++) {
            for (int j = 0; j < tChars.length; j++) {
                int diff = 0;
                for (int pos = 0; i + pos < sChars.length && j + pos < tChars.length; pos++) {
                    if (sChars[i + pos] != tChars[j + pos] && ++diff > 1) {
                        break;
                    }
                    res += diff;
                }
            }
        }

        return res;
    }
}
