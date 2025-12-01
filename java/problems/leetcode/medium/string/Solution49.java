package problems.leetcode.medium.string;


import java.util.*;

/**
 * Problem: <a href="https://leetcode.com/problems/group-anagrams">
 * group-anagrams</a>
 * Time Complexity:
 * Space Complexity：
 */
class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String str : strs) {
            String letterCode = getLetterCode(str);
            if (map.containsKey(letterCode)) {
                res.get(map.get(letterCode)).add(str);
            } else {
                map.put(letterCode, res.size());
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(str);
            }
        }

        return res;
    }

    public List<List<String>> groupAnagrams1(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String letterCode = new String(chars);
            map.putIfAbsent(letterCode, new ArrayList<>());
            map.get(letterCode).add(str);
        }

        return map.values().stream().toList();
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String letterCode = getLetterCode(str);
            map.putIfAbsent(letterCode, new ArrayList<>());
            map.get(letterCode).add(str);
        }

        return map.values().stream().toList();
    }

    private String getLetterCode(String str) {
        char[] letterCount = new char[26];
        for (char c : str.toCharArray()) {
            letterCount[c - 'a']++;
        }

        return new String(letterCount);
    }
}
