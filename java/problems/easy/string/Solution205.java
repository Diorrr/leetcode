package problems.easy.string;


/**
 * Problem: <a href="https://leetcode.com/problems/isomorphic-strings">
 * isomorphic-strings</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        Character[] map = new Character[256];
        boolean[] used = new boolean[256];
        for (int i = 0; i < s.length(); i++) {
            var sChar = s.charAt(i);
            var tChar = t.charAt(i);
            if (map[sChar] == null && !used[tChar]) {
                map[sChar] = tChar;
                used[tChar] = true;
            } else if (map[sChar] == null || map[sChar] != tChar) {
                return false;
            }
        }
        return true;
    }
}
