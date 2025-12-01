package problems.leetcode.hard.dfs;

import java.util.*;

/**
 * Problem: https://leetcode.com/problems/concatenated-words/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution472 {
    Set<String> wordsSet;
    Map<String, Boolean> available;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        wordsSet = new HashSet<>(Arrays.asList(words));
        available = new HashMap<>();
        for (String word : words) {
            if (isReachable(word)) {
                res.add(word);
            }
        }

        return res;
    }

    private boolean isReachable(String word) {
        if (available.containsKey(word)) {
            return available.get(word);
        }
        for (int i = 1; i < word.length(); i++) {
            String pref = word.substring(0, i), suf = word.substring(i);
            if ((wordsSet.contains(pref) && wordsSet.contains(suf)) || (wordsSet.contains(pref) && isReachable(suf))) {
                available.put(word, true);
                return true;
            }
        }
        available.put(word, false);

        return false;
    }
}
