package problems.easy.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Problem: <a href="https://leetcode.com/problems/word-pattern">
 * word-pattern</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution290 {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> letterToWordMap = new HashMap<>();
        Map<String, Character> wordToLetterMap = new HashMap<>();
        List<String> words = Arrays.stream(s.split(" ")).toList();
        if (pattern.length() != words.size()) {
            return false;
        }

        for (int i = 0; i < pattern.length(); i++) {
            char letter = pattern.charAt(i);
            String word = words.get(i);
            if (letterToWordMap.containsKey(letter)) {
                if (!letterToWordMap.get(letter).equals(word) || letter != wordToLetterMap.get(word)) {
                    return false;
                }
            } else {
                if (wordToLetterMap.containsKey(word)) {
                    return false;
                }
                letterToWordMap.put(letter, word);
                wordToLetterMap.put(word, letter);
            }
        }
        return true;
    }
}
