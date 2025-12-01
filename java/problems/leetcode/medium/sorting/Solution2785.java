package problems.leetcode.medium.sorting;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem: <a href="https://leetcode.com/problems/sort-vowels-in-a-string">
 * sort-vowels-in-a-string</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution2785 {
    public String sortVowels(String s) {
        char[] chars = s.toCharArray();
        List<Integer> index = new ArrayList<>();
        List<Character> vowels = List.of('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u');
        int[] count = new int[vowels.size()];
        HashMap<Character, Integer> vowelIndex = new HashMap<>();
        for (int i = 0; i < vowels.size(); i++) {
            vowelIndex.put(vowels.get(i), i);
        }
        for (int i = 0; i < chars.length; i++) {
            if (vowelIndex.get(chars[i]) != null) {
                index.add(i);
                count[vowelIndex.get(chars[i])]++;
            }
        }
        int pos = 0;
        for (int i = 0; i < vowels.size(); i++) {
            while (count[i] != 0) {
                chars[index.get(pos)] = vowels.get(i);
                pos++;
                count[i]--;
            }
        }

        return new String(chars);
    }

    public String sortVowels2(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        List<Integer> index = new ArrayList<>();
        List<Character> vowelsToSort = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (vowels.contains(chars[i])) {
                index.add(i);
                vowelsToSort.add(chars[i]);
            }
        }
        vowelsToSort.sort(Character::compareTo);
        for (int i = 0; i < index.size(); i++) {
            chars[index.get(i)] = vowelsToSort.get(i);
        }

        return new String(chars);
    }
}
