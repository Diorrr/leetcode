package problems.easy.string;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/uncommon-words-from-two-sentences">
 * uncommon-words-from-two-sentences</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        List<String> res = new ArrayList<>();
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : (s1 + " " + s2).split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        count.forEach((k, v) -> {
            if (v == 1) {
                res.add(k);
            }
        });

        return res.toArray(String[]::new);
    }

    public String[] uncommonFromSentences1(String s1, String s2) {
        Set<String> res = new HashSet<>();
        Set<String> duplicate = new HashSet<>();

        for (String s : s1.split(" ")) {
            if (res.contains(s)) {
                duplicate.add(s);
            }
            res.add(s);
        }
        for (String s : s2.split(" ")) {
            if (res.contains(s)) {
                duplicate.add(s);
            }
            res.add(s);
        }
        res.removeAll(duplicate);
        return res.toArray(String[]::new);
    }

    public String[] uncommonFromSentences2(String s1, String s2) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String word : (s1 + " " + s2).split(" ")) {
            count.put(word, count.getOrDefault(word, 0) + 1);
        }
        return count.entrySet().stream()
                    .filter(v -> v.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .toArray(String[]::new);
    }
}
