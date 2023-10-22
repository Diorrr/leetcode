package problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem: <a href="https://leetcode.com/problems/find-all-anagrams-in-a-string">
 * find-all-anagrams-in-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];
        p.chars().forEach(item -> count[(char) item - 'a']++);
        for (int i = 0; i < p.length(); i++) {
            count[s.charAt(i) - 'a']--;
        }
        if (checkBalance(count)) {
            res.add(0);
        }
        for (int i = p.length(); i < s.length(); i++) {
            count[s.charAt(i - p.length()) - 'a']++;
            count[s.charAt(i) - 'a']--;
            if (checkBalance(count)) {
                res.add(i - p.length() + 1);
            }
        }

        return res;
    }

    private boolean checkBalance(int[] count) {
        return Arrays.stream(count).allMatch(t -> t == 0);
    }
}
