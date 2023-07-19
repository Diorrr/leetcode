package problems.medium.string;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Problem: <a href="https://leetcode.com/problems/group-anagrams">
 * group-anagrams</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String letterCode = getLetterCode(str);
            map.putIfAbsent(letterCode, new ArrayList<>());
            map.get(letterCode).add(str);
        }

        return map.values().stream().toList();
    }

    private String getLetterCode(String str) {
        int[] letterCount = new int[26];
        for (char c : str.toCharArray()) {
            letterCount[c - 'a']++;
        }

        return Arrays.stream(letterCount)
                     .mapToObj(t-> t +",")
                     .collect(Collectors.joining());
    }
}
