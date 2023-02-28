package problems.medium.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem: https://leetcode.com/problems/longest-word-in-dictionary/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution720 {
    public String longestWord(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, (a, b) -> {
            if (a.equals(b)) {
                return 0;
            } else if (a.length() > b.length() || (a.length() == b.length() && a.compareTo(b) < 0)) {
                return -1;
            } else {
                return 1;
            }
        });
        for (String word : words) {
            if (isReachable(word, set)) {
                return word;
            }
        }

        return "";
    }

    private boolean isReachable(String word, Set<String> set) {
        if (word.length() == 1 && set.contains(word)) {
            return true;
        }

        return set.contains(word) && isReachable(word.substring(0, word.length() - 1), set);
    }

    public String longestWord2(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        Arrays.sort(words, Comparator.comparingInt(String::length));
        String res = "";
        for (int i = words.length - 1; i >= 0 && res.length() <= words[i].length(); i--) {
            if (isReachable(words[i], set)) {
                if (res.length() < words[i].length() || res.compareTo(words[i]) > 0) {
                    res = words[i];
                }
            }
        }

        return res;
    }
}
