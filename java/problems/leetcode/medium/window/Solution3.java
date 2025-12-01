package problems.leetcode.medium.window;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters">
 * longest-substring-without-repeating-characters</a>
 * Time Complexity: O(N)
 * Space Complexity： O(1)
 */
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        int[] charPos = new int[256];
        for (int i = 0; i < s.length(); i++) {
            start = charPos[s.charAt(i)] > 0 ? Math.max(start, charPos[s.charAt(i)]) : start;
            charPos[s.charAt(i)] = i+1;
            res = Math.max(res, i - start + 1);
        }

        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        } else if (s.length() == 1) {
            return 1;
        } else {
            int res = 0;
            int left = 0, right = 0;
            Map<Character, Integer> map = new HashMap<>();
            char[] chars = s.toCharArray();
            char lchar, rchar;
            while (right < s.length()) {
                rchar = chars[right];
                lchar = chars[left];
                if (map.containsKey(rchar)) {
                    if (map.get(rchar) > 0) {
                        map.put(lchar, map.get(lchar) - 1);
                        left++;
                    } else {
                        map.put(rchar, 1);
                        res = Math.max(res, right - left + 1);
                        right++;
                    }
                } else {
                    map.put(rchar, 1);
                    res = Math.max(res, right - left + 1);
                    right++;
                }
            }
            return res;
        }
    }
}
