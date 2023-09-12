package problems.medium.greedy;


import java.util.HashMap;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique">
 * minimum-deletions-to-make-character-frequencies-unique</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1647 {
    public int minDeletions(String s) {
        char[] chars = s.toCharArray();
        int res = 0;
        int[] charCount = new int[26];
        Map<Integer, Boolean> map = new HashMap<>();

        for (char c : chars) {
            charCount[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (charCount[i] != 0) {
                if (map.get(charCount[i]) == null) {
                    map.put(charCount[i], true);
                } else {
                    int pos = 0;
                    for (int j = charCount[i] - 1; j > 0; j--) {
                        if (map.get(j) == null) {
                            map.put(j, true);
                            pos = j;
                            break;
                        }
                    }
                    res += charCount[i] - pos;
                }
            }
        }

        return res;
    }
}
