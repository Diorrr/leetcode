package problems.leetcode.medium.hashtable;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/split-a-string-into-the-max-number-of-unique-substrings">
 * split-a-string-into-the-max-number-of-unique-substrings</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution1593 {
    int res = 1;

    public int maxUniqueSplit(String s) {
        findComb(s.toCharArray(), new HashMap<>(), 0, 0);
        return res;
    }

    private void findComb(char[] s, HashMap<String, Integer> map, int index, int count) {
        if (index == s.length) {
            res = Math.max(count, res);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = index; i < s.length; i++) {
            sb.append(s[i]);
            if (map.getOrDefault(sb.toString(), 0) == 0) {
                map.put(sb.toString(), 1);
                findComb(s, map, i + 1, count + 1);
                map.put(sb.toString(), 0);
            }
        }
    }

    public int maxUniqueSplit2(String s) {
        findComb(s, new HashSet<>());
        return res;
    }

    private void findComb(String s, Set<String> set) {
        if (s.isEmpty()) {
            res = Math.max(set.size(), res);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if (!set.contains(sb.toString())) {
                set.add(sb.toString());
                findComb(s.substring(i + 1), set);
                set.remove(sb.toString());
            }
        }
    }
}
