package problems.medium.bit;


import java.util.HashMap;

/**
 * Problem: <a href="https://leetcode.com/problems/find-the-longest-substring-containing-vowels-in-even-counts">
 * find-the-longest-substring-containing-vowels-in-even-counts</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1371 {
    public int findTheLongestSubstring(String s) {
        int res = 0;
        int curr = 0;
        HashMap<Integer, Integer> pos = new HashMap<>();
        pos.put(0, -1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                curr ^= c;
            }
            pos.putIfAbsent(curr, i);
            res = Math.max(res, i - pos.get(curr));
        }
        return res;
    }
}
