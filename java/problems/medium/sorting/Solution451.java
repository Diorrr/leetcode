package problems.medium.sorting;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem: https://leetcode.com/problems/sort-characters-by-frequency/description/
 * Time Complexity:
 * Space Complexity：
 */
class Solution451 {
    public String frequencySort(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        List<Character>[] bucket = new List[s.length() + 1];

        for (Character character : s.toCharArray()) {
            freq.put(character, freq.getOrDefault(character, 0) + 1);
        }

        freq.keySet().forEach(key -> {
            if (bucket[freq.get(key)] == null) {
                bucket[freq.get(key)] = new ArrayList<>();
            }
            bucket[freq.get(key)].add(key);
        });

        StringBuilder builder = new StringBuilder(s.length());
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                int finalI = i;
                bucket[i].forEach(c->{
                    builder.append(String.valueOf(c).repeat(finalI));
                });
            }
        }

        return builder.toString();
    }

    public String frequencySort1(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        List<String>[] bucket = new List[s.length() + 1];

        for (Character character : s.toCharArray()) {
            freq.put(character, freq.getOrDefault(character, 0) + 1);
        }

        freq.keySet().forEach(key -> {
            if (bucket[freq.get(key)] == null) {
                bucket[freq.get(key)] = new ArrayList<>();
            }
            bucket[freq.get(key)].add(String.valueOf(key).repeat(freq.get(key)));
        });

        StringBuilder builder = new StringBuilder(s.length());
        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                builder.append(bucket[i].stream().map(String::valueOf).collect(Collectors.joining()));
            }
        }

        return builder.toString();
    }

    public String frequencySort2(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        var chars = s.chars()
                .mapToObj(c -> (char) c)
                .toArray(Character[]::new);
        for (Character character : s.toCharArray()) {
            freq.put(character, freq.getOrDefault(character, 0) + 1);
        }
        Arrays.sort(chars, (a, b) ->
                !freq.get(b).equals(freq.get(a)) ? freq.get(b) - freq.get(a) : a.compareTo(b));


        return Arrays.stream(chars).map(String::valueOf).collect(Collectors.joining());
    }
}
