package problems.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string">
 * find-all-anagrams-in-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        int balance = -p.length();
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        p.chars().forEach(item -> count[(char) item - 'a']--);

        for (int i = 0; i < s.length(); i++) {
            if (i >= p.length()) {
                if (count[s.charAt(i - p.length()) - 'a'] > 0) {
                    balance++;
                } else {
                    balance--;
                }
                count[s.charAt(i - p.length()) - 'a']--;
            }

            if (count[s.charAt(i) - 'a'] < 0) {
                balance++;
            } else {
                balance--;
            }
            count[s.charAt(i) - 'a']++;

            if (balance == 0) {
                res.add(i - p.length() + 1);
            }
        }

        return res;
    }
}
