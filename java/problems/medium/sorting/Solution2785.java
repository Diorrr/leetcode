package problems.medium.sorting;


import java.util.ArrayList;
import java.util.Arrays;
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
