package problems.easy.string;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/isomorphic-strings">
 * isomorphic-strings</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution205 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Set<Character> used = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            var sChar = s.charAt(i);
            var tChar = t.charAt(i);
            if (!map.containsKey(sChar) && !used.contains(tChar)) {
                map.put(sChar, tChar);
                used.add(tChar);
            }

            if (!map.containsKey(sChar) || map.get(sChar) != tChar) {
                return false;
            }
        }
        return true;
    }
}
